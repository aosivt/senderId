package sender.UIObject.FillingUI.DragFileUploadPanel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sender.Entity.*;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CreataRowAllDB {

    private Departments departmemts;
    private EmailPost emailPost;
    private PivotTable pivotTable;
    private Post post;
    private SNPStaff snpStaff;
    private Telephone telephone;

    private Session session;

    public CreataRowAllDB(){

        session = HibernateUtil.getSessionFactory().openSession();
    }

    public CreataRowAllDB(String _snpStaff, String _post,String _departments,
                          String _telephone,String _emailPost){

                    setDepartmemts(_departments)
                    .setEmailPost(_emailPost)
                    .setPost(_post)
                    .setSnpStaff(_snpStaff)
                    .setTelephone(_telephone)
                    .setPivotTable();

    Session session = HibernateUtil.getSessionFactory().openSession();

    Transaction transaction = session.beginTransaction();
    session.save(getDepartmemts());
    session.save(getEmailPost());
    session.save(getPost());
    session.save(getSnpStaff());
    session.save(getTelephone());
    session.save(getPivotTable());
    transaction.commit();
    session.clear();
    session.close();
    }

    public void addObjectToDB(String _snpStaff, String _post,String _departments,
                              String _telephone,String _emailPost){

        setDepartmemts(_departments)
                .setEmailPost(_emailPost)
                .setPost(_post)
                .setSnpStaff(_snpStaff)
                .setTelephone(_telephone)
                .setPivotTable();

        Transaction transaction = getSession().beginTransaction();
        getSession().save(getDepartmemts());
        getSession().save(getEmailPost());
        getSession().save(getPost());
        getSession().save(getSnpStaff());
        getSession().save(getTelephone());
        getSession().save(getPivotTable());
        transaction.commit();
        sessionClear();
    }

    public Departments getDepartmemts() {
        return departmemts;
    }

    private CreataRowAllDB setDepartmemts(String departmemts) {
        this.departmemts = new Departments();
        this.departmemts.setName_departments(departmemts);
        return this;

    }

    public EmailPost getEmailPost() {
        return emailPost;
    }

    private CreataRowAllDB setEmailPost(String emailPost) {
        this.emailPost = new EmailPost();
        this.emailPost.setNameEmailPost(emailPost);
        return this;
    }

    public PivotTable getPivotTable() {
        return pivotTable;

    }

    private CreataRowAllDB setPivotTable() {
        List<PivotTable> temp = new ArrayList<PivotTable>();
        pivotTable = new PivotTable();
        pivotTable.setDepartments(getDepartmemts());
        pivotTable.setEmailPost(getEmailPost());
        pivotTable.setPosts(getPost());
        pivotTable.setTelephone(getTelephone());
        pivotTable.setSnpStaff(getSnpStaff());
        temp.add(pivotTable);
        post.setPivot_tables(temp);
        emailPost.setPivot_tables(temp);
        departmemts.setPivot_tables(temp);
        snpStaff.setPivot_tables(temp);
        telephone.setPivot_tables(temp);
        return this;
    }

    public Post getPost() {
        return post;
    }

    private CreataRowAllDB setPost(String  post) {
        this.post = new Post();
        this.post.setNamePost(post);
        return this;
    }

    public SNPStaff getSnpStaff() {
        return snpStaff;
    }

    private CreataRowAllDB setSnpStaff(String snpStaff) {
        this.snpStaff = new SNPStaff();
        this.snpStaff.setNameStaff(snpStaff);
        return this;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    private CreataRowAllDB setTelephone(String telephone) {
        this.telephone = new Telephone();
        this.telephone.setNumberTelephone(telephone);
        return this;
    }

    private Session getSession() {
        return session;
    }

    private void sessionClear(){
        session.clear();
//        session.close();
    }

}
