LOAD CSV WITH HEADERS FROM 'file:///wt_wealth_management-current-2021-02-01_13_11_52.csv' AS line

MERGE (stock: Stock {id:line.Symbol, name:line.Stock, sector: line.sector})
MERGE (fund:Fund {fund: "wt wealth"})
MERGE (sector:Sector {name:line.sector})

MERGE (fund)-[:HOLDING]->(stock)
MERGE (stock)-[:STOCK_SECTOR]->(sector)


