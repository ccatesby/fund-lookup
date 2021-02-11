package funds.spring.neo4j.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.*;

@NodeEntity
public class Stock implements Searchable{

    @Id
    private Long id;

    private String name;

    private String type;
    
    @Relationship(type = "HOLDING")
    private List<Holding> funds = new ArrayList<>();
    public Stock() {
    }

    public Stock(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Holding> getFunds() {
        return funds;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
