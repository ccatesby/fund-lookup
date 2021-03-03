package funds.spring.neo4j.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import funds.spring.neo4j.model.Fund;


@Repository
public class FundDAO implements IFundDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Fund> filterFunds(String query) {
	
		  Map<String, Object> params = new HashMap<>();
		
		  List<Fund> funds = new ArrayList<Fund>();

          StringBuilder buildQuery = new StringBuilder();
          buildQuery.append("MATCH (f:Fund)-[h:HOLDING]->(s:Stock)")
          .append(" WHERE " + query)
          .append(" RETURN f, h, s");

          Iterable<Fund> fundList = sessionFactory.openSession().query(Fund.class, buildQuery.toString(), params);

          Iterator<Fund> itr = fundList.iterator();
          while(itr.hasNext())
          {
            funds.add(itr.next());
          }
          
          return funds;
	}

}