package funds.spring.neo4j.repositories;

import java.util.List;

import funds.spring.neo4j.model.Fund;

public interface IFundDAO {
	public List<Fund> filterFunds(String query);
}
