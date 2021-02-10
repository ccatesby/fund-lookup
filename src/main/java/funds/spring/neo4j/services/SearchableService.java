package funds.spring.neo4j.services;

import funds.spring.neo4j.model.Searchable;
import funds.spring.neo4j.repositories.SearchableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchableService {


    @Autowired
    SearchableRepository searchableRepository;

    public List<Searchable> getSearchableByName(String name) {
        return searchableRepository.findByName(name);
    }
}
