package sender.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "email_posts")
public class EmailPost implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "email_post_id")
    private Long emailPostid;

    @Column(name = "email_post_name")
    private String nameEmailPost;

    @OneToMany(mappedBy = "emailPost",
               fetch = FetchType.LAZY,
            cascade= CascadeType.PERSIST)
    private List<PivotTable> pivot_tables = new ArrayList<PivotTable>();

    public Long getEmailPostid() {
        return emailPostid;
    }

    public void setEmailPostid(Long emailPostid) {
        this.emailPostid = emailPostid;
    }

    public String getNameEmailPost() {
        return nameEmailPost;
    }

    public void setNameEmailPost(String nameEmailPost) {
        this.nameEmailPost = nameEmailPost;
    }

    public List<PivotTable> getPivot_tables() {
        return pivot_tables;
    }

    public void setPivot_tables(List<PivotTable> pivot_tables) {
        this.pivot_tables = pivot_tables;
    }
}
