package funds.graphql.neo4j.dao.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import funds.graphql.neo4j.dao.entity.Fund;

@Repository
public interface FundRepository extends Neo4jRepository<Fund, Long>{
	
	List<Fund> findByName(String name);


	//List<Member> findMemberWithContribution(String name);
}
