package funds.spring.neo4j.services;

import funds.spring.neo4j.model.ForceGraph;
import funds.spring.neo4j.repositories.SearchableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class SearchableService {

    @Autowired
    SearchableRepository searchableRepository;

    public List<ForceGraph> findGraphById(Long id) {
        return searchableRepository.findGraphById(id);
    }
}
