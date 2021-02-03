package funds.spring.data.neo4j.funds;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Value;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 * @author Jennifer Reif
 * @author Michael J. Simons
 */
@Service
public class FundService {

	private final Driver driver;

	private final DatabaseSelectionProvider databaseSelectionProvider;

	FundService(
				 Neo4jClient neo4jClient,
				 Driver driver,
				 DatabaseSelectionProvider databaseSelectionProvider) {

		this.driver = driver;
		this.databaseSelectionProvider = databaseSelectionProvider;
	}

	/**
	 * This is an example of when you might want to use the pure driver in case you have no need for mapping at all, neither in the
	 * form of the way the {@link org.springframework.data.neo4j.core.Neo4jClient} allows and not in form of entities.
	 *
	 * @return A representation D3.js can handle
	 */
	public Map<String, List<Object>> fetchFundGraph() {

		var nodes = new ArrayList<>();
		var links = new ArrayList<>();

		try (Session session = sessionFor(database())) {
			var records = session.readTransaction(tx -> tx.run(""
				+ " MATCH (s:Stock) <- [r:HOLDING] - (f:Fund)"
				+ " WITH s, f ORDER BY s.name, f.fund"
				+ " RETURN s.name AS stock, collect(f.fund) AS funds"
			).list());
			records.forEach(record -> {
				var stock = Map.of("label", "stock",  "title", record.get("stock").asString());

				var targetIndex = nodes.size();
				nodes.add(stock);

				record.get("funds").asList(Value::asString).forEach(name -> {
					var fund = Map.of("label", "fund", "title", name);

					int sourceIndex;
					if (nodes.contains(fund)) {
						sourceIndex = nodes.indexOf(fund);
					} else {
						nodes.add(fund);
						sourceIndex = nodes.size() - 1;
					}
					links.add(Map.of("source", sourceIndex, "target", targetIndex));
				});
			});
		}
		return Map.of("nodes", nodes, "links", links);
	}

	private Session sessionFor(String database) {
		if (database == null) {
			return driver.session();
		}
		return driver.session(SessionConfig.forDatabase(database));
	}

	private String database() {
		return databaseSelectionProvider.getDatabaseSelection().getValue();
	}
}
