package funds.spring.neo4j.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


import funds.spring.neo4j.model.Fund;


import java.util.Optional;

@Repository
public interface FundRepository extends Neo4jRepository<Fund, Long> {
    Optional<Fund> findByName(String name);
}
