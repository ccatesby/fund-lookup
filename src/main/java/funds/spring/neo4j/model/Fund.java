package funds.spring.neo4j.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
public class Fund implements Searchable {

    @Id 
    @GeneratedValue
    private Long id;

    private String name;

    private String type;
    
    @Relationship(type = "HOLDING")
    List<Holding> stocks = new ArrayList<>();

    public Fund() {
    }

    public Fund(Long id) {
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

    public List<Holding> getStocks() {
        return stocks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
