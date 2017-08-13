package sender.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long postid;

    @Column(name = "post_name")
    private String namePost;

    @OneToMany(fetch = FetchType.LAZY,cascade= CascadeType.PERSIST,mappedBy = "posts")
    private List<PivotTable> pivot_tables = new ArrayList<PivotTable>();

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    public List<PivotTable> getPivot_tables() {
        return pivot_tables;
    }

    public void setPivot_tables(List<PivotTable> pivot_tables) {
        this.pivot_tables = pivot_tables;
    }
}
