package funds.graphql.neo4j.dao.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
public class Fund {

	@Id
	private final Long title;

	private final String name;
	private Integer released;

	public Fund(Long title, String name) {
		this.title = title;
		this.name = name;
	}

	public Long getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public Integer getReleased() {
		return released;
	}

	public void setReleased(Integer released) {
		this.released = released;
	}
}
