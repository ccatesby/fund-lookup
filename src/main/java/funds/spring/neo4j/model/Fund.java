package funds.spring.neo4j.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
public class Fund {

    @Id
    private String id;

    private String name;


    @Relationship(type = "HOLDING")
    List<Holding> stocks = new ArrayList<>();

    public Fund() {
    }

    public Fund(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List<Holding> getStocks() {
        return stocks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
