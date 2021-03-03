package funds.spring.neo4j.model;

public class HoldingFilter {

    private Float price;
    private Long shares;
    private Long snapshotFrom;
    private Long snapshotTo;
    private Boolean isCurrent;

    public Float getPrice() {
        return price;
    }
    
    public Long getShares() {
        return shares;
    }

    public Long getSnapshotFrom() {
        return snapshotFrom;
    }
    
    public Long getSnapshotTo() {
        return snapshotTo;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public String getQuery(String operator) {
        return new StringBuilder()
        .append( isCurrent != null ? " " + operator + " h.isCurrent=" + isCurrent : "")
        .toString();
    }
}
