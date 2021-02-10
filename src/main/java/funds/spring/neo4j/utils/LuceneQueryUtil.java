package funds.spring.neo4j.utils;

import org.springframework.stereotype.Component;

@Component
public class LuceneQueryUtil {

    public String createFuzzyQuery(String query) {
        return query + "~";
    }
}
