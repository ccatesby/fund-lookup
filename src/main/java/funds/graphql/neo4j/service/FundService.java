package funds.graphql.neo4j.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import funds.graphql.neo4j.dao.entity.Fund;
import funds.graphql.neo4j.dao.impl.FundDAO;
import funds.graphql.neo4j.dao.repository.FundRepository;

@Service
public class FundService {
	
	@Autowired
    public FundDAO fundDAO;
    
	private final FundRepository fundRepository;
	
	public FundService(final FundRepository fundRepository) {
        this.fundRepository = fundRepository ;
    }
	
	@Transactional(readOnly = true)
    public List<Fund> getAllFunds(final int count) {
        return ((Collection<Fund>) this.fundRepository.findAll()).stream().limit(count).collect(Collectors.toList());
    }

    // @Transactional(readOnly = true) 
	// public List<Fund> searchMemberByNameAndSkillAndEmpId(String name,String skillBucket, Long empId, String pName) {
	// 	  // if all null or blank
		 
	// 	return  fundDAO.searchMember(name,empId,skillBucket,pName);
		 
	// }
}
