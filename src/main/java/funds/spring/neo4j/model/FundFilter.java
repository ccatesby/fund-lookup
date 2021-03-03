package funds.spring.neo4j.model;


public class FundFilter {
    private Long id;
    private String name;
    private HoldingFilter holding_and;
    private HoldingFilter holding_or;
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public HoldingFilter getHolding_and() {
        return holding_and;
    }
    
    public HoldingFilter getHolding_or() {
        return holding_or;
    }

    public String getQuery() {
        return new StringBuilder()
        .append( id != null ? "id(f)=" + id : "")
        .append( name != null ? "f.name=" + name : "")
        .append( holding_and != null ? holding_and.getQuery("AND") : "")
        .append( holding_or != null ? holding_and.getQuery("OR") : "")
        .toString();
    }
}
