package funds.spring.neo4j.repositories;

import funds.spring.neo4j.model.Searchable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SearchableRepository extends Neo4jRepository<Searchable, UUID> {

     @Query("MATCH ({name:\"1832\"})-[*1..2]->(n) RETURN n")
     List<Searchable> findByName(String name);
}
