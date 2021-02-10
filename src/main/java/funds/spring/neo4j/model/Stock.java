package funds.spring.neo4j.model;


import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.*;

@NodeEntity
public class Stock  {

    @Id
    private String id;

    private String name;


    @Relationship(type = "HOLDING")
    private List<Holding> funds = new ArrayList<>();
    public Stock() {
    }

    public Stock(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List<Holding> getFunds() {
        return funds;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
