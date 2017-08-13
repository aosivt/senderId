package sender.Entity;

import org.hibernate.Session;
import sender.util.HibernateUtil;

import javax.persistence.*;

@Entity
@Table(name = "group_pivot_table")
public class GroupPivotTable {

    public GroupPivotTable(){}

    public GroupPivotTable(DistributionGroups distributionGroups, PivotTable pivotTable){
        setDistributionGroups(distributionGroups);
        setPivotTable(pivotTable);

        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.load(this.getClass(),)

    }

    @Id
    @GeneratedValue
    @Column(name = "group_pivot_table_id")
    private Long groupPivotTableid;

    @ManyToOne//(targetEntity = DistributionGroups.class)
//    @JoinTable(name = "distribution_groups")
//    @JoinColumn(name = "distribution_id")
    private DistributionGroups distributionGroups;

    @ManyToOne//(targetEntity = PivotTable.class)
//    @JoinColumn(name = "pivot_table_id")
    private PivotTable pivotTable;

    public Long getGroupPivotTableid() {
        return groupPivotTableid;
    }

    public void setGroupPivotTableid(Long groupPivotTableid) {
        this.groupPivotTableid = groupPivotTableid;
    }

    public DistributionGroups getDistributionGroups() {
        return distributionGroups;
    }

    public void setDistributionGroups(DistributionGroups distributionGroups) {
        this.distributionGroups = distributionGroups;
    }

    public PivotTable getPivotTable() {
        return pivotTable;
    }

    public void setPivotTable(PivotTable pivotTable) {
        this.pivotTable = pivotTable;
    }
}
