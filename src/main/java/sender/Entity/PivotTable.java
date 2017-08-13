package sender.Entity;

import com.vaadin.server.Setter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import sender.Entity.Repository.UpdaterDirectoriesTables;
import sender.util.HibernateUtil;

import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pivot_table")
public class PivotTable implements Serializable {

    public PivotTable(){}

    @Id
    @GeneratedValue
    @Column(name = "pivot_table_id")
    private Long pivotTableid;

    @ManyToOne//(targetEntity = Departments.class)
//    @JoinTable(name = "departments")
//    @JoinColumn(name = "department_id")
    private Departments departments;

    @ManyToOne//(targetEntity = EmailPost.class)
//    @JoinTable(name = "email_posts")
//    @JoinColumn(name = "email_post_id")
    private EmailPost emailPost;

    @ManyToOne//(targetEntity = Post.class)
//    @JoinTable(name = "posts")
//    @JoinColumn(name = "post_id")
    private Post posts;

    @ManyToOne//(targetEntity = SNPStaff.class)
//    @JoinTable(name = "snp_staff")
//    @JoinColumn(name = "snp_staff_id")
    private SNPStaff snpStaff;

    @ManyToOne//(targetEntity = Telephone.class)
//    @JoinTable(name = "telephone")
//    @JoinColumn(name = "telephone_id")
    private Telephone telephone;

    @OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.PERSIST
            ,mappedBy = "pivotTable"
    )
    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinTable(name = "telephone")
//    @JoinColumn(name = "pivot_table_id")

    private List<SMSSending> smsSendings= new ArrayList<SMSSending>();

    @OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.PERSIST
            ,mappedBy = "pivotTable"
    )
    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinTable(name = "telephone")
//    @JoinColumn(name = "pivot_table_id")
    private List<GroupPivotTable> groupPivotTable;

    public Long getPivotTableid() {
        return pivotTableid;
    }

    public void setPivotTableid(Long pivotTableid) {
        this.pivotTableid = pivotTableid;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public EmailPost getEmailPost() {
        return emailPost;
    }

    public void setEmailPost(EmailPost emailPost) {
        this.emailPost = emailPost;
    }

    public Post getPosts() {
        return posts;
    }

    public void setPosts(Post posts) {
        this.posts = posts;
    }

    public SNPStaff getSnpStaff() {
        return snpStaff;
    }

    public void setSnpStaff(SNPStaff snpStaff) {
        this.snpStaff = snpStaff;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public List<SMSSending> getSmsSendings() {
        return smsSendings;
    }

    public void setSmsSendings(List<SMSSending> smsSendings) {
        this.smsSendings = smsSendings;
    }

    public List<GroupPivotTable> getGroupPivotTable() {
        return groupPivotTable;
    }

    public void setGroupPivotTable(List<GroupPivotTable> groupPivotTable) {
        this.groupPivotTable = groupPivotTable;
    }

    public String getSnpStaffName(){
        return getSnpStaff().getNameStaff();
    }

    public void setSnpStaffName(String name){
        getSnpStaff().setNameStaff(name);
        UpdaterDirectoriesTables.update(getSnpStaff());
    }

    public String getTelephoneNumber(){
        return getTelephone().getNumberTelephone();
    }

    public void setTelephoneNumber(String number){
        getTelephone().setNumberTelephone(number);
        UpdaterDirectoriesTables.update(getTelephone());
    }

    public String getPostName(){
        return getPosts().getNamePost();
    }

    public void setPostsName(String name){
        getPosts().setNamePost(name);
        UpdaterDirectoriesTables.update(getPosts());
    }

    public String getEmailPostName(){
        return getEmailPost().getNameEmailPost();
    }

    public void setEmailPosts(String name){
        getEmailPost().setNameEmailPost(name);
        UpdaterDirectoriesTables.update(getEmailPost());
    }

    public String getDepartmentsName(){
        return getDepartments().getNameDepartments();
    }

    public void setDepartmentsName(String name){
        getDepartments().setName_departments(name);
        UpdaterDirectoriesTables.update(getDepartments());
    }


    @Override
    public String toString() {
        return getSnpStaff().getNameStaff() + " - " + getTelephone().toString();
    }




}
