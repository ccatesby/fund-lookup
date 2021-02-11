package funds.spring.neo4j.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "HOLDING")
public class Holding implements Edge {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    Fund fund;

    @EndNode
    Stock stock;

    public Holding() {
    }

    public Holding(Stock stock, Fund fund) {
        this.stock = stock;
        this.fund = fund;
    }

    public Long getId() {
        return id;
    }

    public Fund getFund() {
        return fund;
    }

    public Stock getStock() {
        return stock;
    }
}
