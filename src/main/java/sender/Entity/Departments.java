package sender.Entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Departments implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long departmentsId;

    @Column(name = "department_name")
    private String nameDepartments;

    @OneToMany( fetch = FetchType.LAZY,cascade= CascadeType.PERSIST,
                mappedBy = "departments")
    private List<PivotTable> pivot_tables = new ArrayList<PivotTable>();

    public Long getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(Long departmentsId) {
        this.departmentsId = departmentsId;
    }

    public String getNameDepartments() {
        return nameDepartments;
    }

    public void setName_departments(String nameDepartments) {
        this.nameDepartments = nameDepartments;
    }

    public List<PivotTable> getPivot_tables() {
        return pivot_tables;
    }

    public void setPivot_tables(List<PivotTable> pivot_tables) {
        this.pivot_tables = pivot_tables;
    }
}
