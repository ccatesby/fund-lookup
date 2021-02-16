package funds.spring.neo4j.repositories;

import funds.spring.neo4j.model.ForceGraph;
import funds.spring.neo4j.model.Searchable;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.UUID;

@Repository
public interface SearchableRepository extends Neo4jRepository<Searchable, UUID> {

     @Query("MATCH (n) WHERE id(n)= $nodeId OPTIONAL MATCH (n)-[r]-(k) WITH COLLECT(DISTINCT(n))+COLLECT(k) AS nodes, COLLECT({id: ID(r), type: r.type, source: ID(n), target: ID(k)}) AS links RETURN nodes, links")
     List<ForceGraph> findGraphById(Long nodeId);
}
