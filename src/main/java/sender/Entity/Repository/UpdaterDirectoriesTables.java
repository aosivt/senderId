package sender.Entity.Repository;

import org.hibernate.Session;
import sender.Entity.*;
import sender.Entity.Repository.DirectoriesInterfaces.DirectoryOperations;
import sender.util.HibernateUtil;

import java.io.Serializable;

public class UpdaterDirectoriesTables {

    public static void update(Serializable serializable){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(serializable);
        session.getTransaction().commit();
        session.clear();
        session.close();
    }
}
