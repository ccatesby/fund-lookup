package funds.spring.neo4j.services;

import funds.spring.neo4j.model.Stock;
import funds.spring.neo4j.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public Optional<Stock> getStock(Long id) {
        return stockRepository.findById(id);
    }
    public Optional<Stock> getStockByName(String name) {
        return stockRepository.findByName(name);
    }
}
