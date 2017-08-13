package sender.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "snp_staff")
public class SNPStaff implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "staff_id")
    private Long staffid;

    @Column(name = "staff_name")
    private String nameStaff;

    @OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.PERSIST,mappedBy = "snpStaff")
    private List<PivotTable> pivot_tables = new ArrayList<PivotTable>();


    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public SNPStaff setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
        return this;
    }

    public List<PivotTable> getPivot_tables() {
        return pivot_tables;
    }

    public void setPivot_tables(List<PivotTable> pivot_tables) {
        this.pivot_tables = pivot_tables;
    }



    @Override
    public String toString() {
        return nameStaff;
    }
}
