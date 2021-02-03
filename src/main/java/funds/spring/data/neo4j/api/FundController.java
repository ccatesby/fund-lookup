package funds.spring.data.neo4j.api;

import funds.spring.data.neo4j.funds.FundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
class FundController {

	private final FundService fundService;

	FundController(FundService fundService) {
		this.fundService = fundService;
	}

	@GetMapping("/graph")
	public Map<String, List<Object>> getGraph() {
		return fundService.fetchFundGraph();
	}
}
