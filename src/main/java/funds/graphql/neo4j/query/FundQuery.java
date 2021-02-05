package funds.graphql.neo4j.query;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import funds.graphql.neo4j.dao.entity.Fund;
import funds.graphql.neo4j.service.FundService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class FundQuery implements GraphQLQueryResolver{
	
    private final FundService fundService;
	
	public FundQuery(final FundService fundService) {
        this.fundService = fundService ;
    }

	public List<Fund> getFunds(final int count) {
        return this.fundService.getAllFunds(count);
    }	
}
