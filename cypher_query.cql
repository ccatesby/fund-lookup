LOAD CSV WITH HEADERS FROM 'file:///wt_wealth_management-current-2021-02-01_13_11_52.csv' AS line

MERGE (stock: Stock {id:line.Symbol, name:line.Stock, sector: line.sector})
MERGE (fund:Fund {fund: "wt wealth"})
MERGE (sector:Sector {name:line.sector})

MERGE (holding:HOLDING {price:line["Recent Price"], shares: line["Shares Held"], date: ["source_date"] })

MERGE (fund)-[:HOLDING]->(stock)
MERGE (stock)-[:STOCK_SECTOR]->(sector)




LOAD CSV WITH HEADERS FROM "https://docs.google.com/spreadsheets/d/e/2PACX-1vTEAJmEPyVVJFQz2XnlWuU2T4RyXoLnnatcBIlkWyEvnEDhBwBz7dHOlKnHODfsi_tueWuXLh8b8Qvb/pub?output=csv" AS line

MERGE (stock: Stock {id:line.Symbol, name:line.Stock})
MERGE (fund:Fund {name: "1832", type: "Fund"})

MERGE (sector:Sector {name:coalesce(line.sector, "Unknown"),type: "Sector"})

WITH fund,stock,line
MATCH (fund)-[r:HOLDING ]->(stock)
WHERE r.snapshot_to = 0 AND r.snapshot_from <> line["source_date"]
SET r.snapshot_to = line["source_date"]

WITH fund, stock,line
MERGE (fund)-[:HOLDING {price:5, shares: line["Shares Held"], type:"holding", snapshot_to:0, snapshot_from: line["source_date"] }]->(stock)



MERGE (stock)-[:STOCK_SECTOR{ type: "stock_sector" }]->(sector)