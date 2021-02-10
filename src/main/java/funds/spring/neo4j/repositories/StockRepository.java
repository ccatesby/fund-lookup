package funds.spring.neo4j.repositories;

import funds.spring.neo4j.model.Stock;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StockRepository extends Neo4jRepository<Stock, Long> {
    Optional<Stock> findByName(String name);
}
