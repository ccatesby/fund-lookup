package funds.spring.neo4j.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NodeEntity
public class Sector implements Searchable {

    @Id
    private Long id;

    private String name;

    private String type;
    

    public Sector() {
    }

    public Sector(Long id) {
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



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
