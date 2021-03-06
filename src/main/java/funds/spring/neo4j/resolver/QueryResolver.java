package funds.spring.neo4j.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import funds.spring.neo4j.model.*;
import funds.spring.neo4j.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public Optional<Fund> getFundById(Long id) {
        return fundService.getFund(id);
    }

    public List<Fund> getFunds(FundFilter filter) {
        return fundService.getFundByFilter(filter.getQuery());
    }

    public Optional<Stock> getStockByName(String name) {
        LOGGER.info("Getting person by name: {}", name);
        return stockService.getStockByName(name);
    }

    public Sector getSectorByName(String name) {
        LOGGER.info("Getting sector by name: {}", name);
        return new Sector();
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

    public List<Fund> getAllFunds(int page, int size) {
        LOGGER.info("Get all Funds");
        
        return fundService.findAll(PageRequest.of(page, size));
    }
}
