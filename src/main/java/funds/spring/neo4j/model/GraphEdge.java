package funds.spring.neo4j.model;

public class GraphEdge {

    private Long id;

    private String type;

    private Long source;
    
    private Long target;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Long getSource() {
        return source;
    }

    public Long getTarget() {
        return target;
    }
}
