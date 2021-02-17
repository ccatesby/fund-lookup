package funds.spring.neo4j.services;

import funds.spring.neo4j.model.Fund;
import funds.spring.neo4j.repositories.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundService {

    @Autowired
    FundRepository fundRepository;

    public Optional<Fund> getFund(Long id) {
        return fundRepository.findById(id, 2);
    }

    public Optional<Fund> getFundByName(String name) {
        return fundRepository.findByName(name);
    }

    public List<Fund> findAll(PageRequest pageRequest) {
        return fundRepository.findAll(pageRequest).getContent();
    }
}
