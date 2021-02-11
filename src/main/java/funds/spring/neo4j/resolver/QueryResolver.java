package funds.spring.neo4j.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import funds.spring.neo4j.model.*;
import funds.spring.neo4j.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryResolver.class);

    @Autowired
    FundService fundService;

    @Autowired
    StockService stockService;

    @Autowired
    SearchableService searchableService;

    public Optional<Fund> getFundByName(String name) {
        LOGGER.info("Getting genre by name: {}", name);
        return fundService.getFundByName(name);
    }

    public Optional<Stock> getStockByName(String name) {
        LOGGER.info("Getting person by name: {}", name);
        return stockService.getStockByName(name);
    }

    public String healthcheck(String info) {
        LOGGER.info("Healthcheck: {}", info);
        return "Healthcheck: " + info;
    }
    
    public ForceGraph getGraphById(Long id) {
        LOGGER.info("Get Graph:", id);
        
        var result = searchableService.findGraphById(id);

        return result.get(0);
    }
}
