package funds.spring.neo4j.repositories;

import funds.spring.neo4j.model.Holding;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRelationRepository extends Neo4jRepository<Holding, Long> {

}
