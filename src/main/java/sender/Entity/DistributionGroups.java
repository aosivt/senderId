package sender.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "distribution_groups")
public class DistributionGroups {
    @Id
    @GeneratedValue
    @Column(name = "distribution_id")
    private Long distributionId;

    @Column(name = "distribution_name")
    private String nameDistribution;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade= CascadeType.PERSIST,
            mappedBy = "distributionGroups")
//    @JoinTable(name = "telephone")
//    @JoinColumn(name = "pivot_table_id")
    private List<GroupPivotTable> groupPivotTables;

    public Long getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Long distributionId) {
        this.distributionId = distributionId;
    }

    public String getNameDistribution() {
        return nameDistribution;
    }

    public void setNameDistribution(String nameDistribution) {
        this.nameDistribution = nameDistribution;
    }

    public List<GroupPivotTable> getGroupPivotTables() {
        return groupPivotTables;
    }

    public void setGroupPivotTables(List<GroupPivotTable> groupPivotTables) {
        this.groupPivotTables = groupPivotTables;
    }
}
