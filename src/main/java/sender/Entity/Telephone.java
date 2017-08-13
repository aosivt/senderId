package sender.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "telephone")
public class Telephone  implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "telephone_id")
    private Long telephoneId;

    @Column(name = "telephone_number")
    private String numberTelephone;

    @OneToMany(mappedBy = "telephone",fetch = FetchType.LAZY,cascade= CascadeType.PERSIST)
    private List<PivotTable> pivot_tables = new ArrayList<PivotTable>();

    public Long getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(Long telephoneId) {
        this.telephoneId = telephoneId;
    }

    public String getNumberTelephone() {
        return numberTelephone;
    }

    public void setNumberTelephone(String numberTelephone) {
        this.numberTelephone = numberTelephone;
    }

    public List<PivotTable> getPivot_tables() {
        return pivot_tables;
    }

    public void setPivot_tables(List<PivotTable> pivot_tables) {
        this.pivot_tables = pivot_tables;
    }

    @Override
    public String toString() {
        return getNumberTelephone();
    }
}
