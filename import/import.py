from neo4j import GraphDatabase
import os

class Neo4jSeedSECReports:

    def __init__(self, uri, user, password):
        self.driver = GraphDatabase.driver(uri, auth=(user, password))

    def close(self):
        self.driver.close()

    def seed_database(self):
        with self.driver.session() as session:
            greeting = session.write_transaction(self._seed_reports)

    @staticmethod
    def _seed_reports(tx):
        arr = os.listdir('import/files')
        for file in arr:
            fundName = file.split("-")[0].replace("_", " ")
            print(fundName)
            result = tx.run(
                f"""
                LOAD CSV WITH HEADERS FROM "file:///{file}" AS line

                MERGE (stock: Stock {{symbol:line.Symbol, name:line.Stock}})
                MERGE (fund:Fund {{name: "{fundName}", type: "Fund"}})

                MERGE (sector:Sector {{name:coalesce(line.sector, "Unknown"),type: "Sector"}})

                WITH fund,stock,line
                OPTIONAL MATCH (fund)-[r:HOLDING ]->(stock)
                WHERE r.snapshotTo = 0
                SET r += {{snapshotTo: timeStamp(), isCurrent: false}}

                WITH fund,stock,line
                MERGE (fund)-[:HOLDING {{price:toFloat(coalesce(line["Recent Price"], 0)), shares: toInteger(line["Shares Held"]), type:"holding", snapshotTo:0, snapshotFrom: timeStamp(), isCurrent: true }}]->(stock)

                MERGE (stock)-[:STOCK_SECTOR{{ type: "stock_sector" }}]->(sector)""")
                
            print(result.single())
        return arr[0]


if __name__ == "__main__":
    seeder = Neo4jSeedSECReports("bolt://localhost:7687", "neo4j", "password")
    seeder.seed_database()
    seeder.close()