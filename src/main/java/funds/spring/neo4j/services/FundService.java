package funds.spring.neo4j.services;

import funds.spring.neo4j.model.Fund;
import funds.spring.neo4j.repositories.FundDAO;
import funds.spring.neo4j.repositories.FundRepository;
import funds.spring.neo4j.repositories.IFundDAO;

import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FundService {

    @Autowired
    FundRepository fundRepository;
    
    @Autowired
    FundDAO fundDAO;

    public Optional<Fund> getFund(Long id) {
        return fundRepository.findById(id, 2);
    }

    public Optional<Fund> getFundByName(String name) {
        return fundRepository.findByName(name);
    }

    public List<Fund> findAll(PageRequest pageRequest) {
        return fundRepository.findAll(pageRequest).getContent();
    }
    
    public List<Fund> getFundByFilter(String filter) {
        return fundDAO.filterFunds(filter);
    }
}
