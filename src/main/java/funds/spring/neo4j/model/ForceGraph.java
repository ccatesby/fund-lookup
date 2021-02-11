package funds.spring.neo4j.model;
import java.util.*;
import org.springframework.data.neo4j.annotation.QueryResult;


@QueryResult
public class ForceGraph {
  
    List<Searchable> nodes;

    List<GraphEdge> links;


    public List<Searchable> getNodes() {
        return nodes;
    }

    public List<GraphEdge> getLinks() {
        return links;
    }
}