package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Recevier;
import POJO.Suppliers;
import POJO.VIEW_SUPPLY;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;

import java.util.Iterator;
import java.util.List;

public class ManageVIEWSUPPLY extends ControllerHIbernate {
    public ManageVIEWSUPPLY() {
    }

    public static void main(String[] args) { //:TODO удалить тестовый блок

        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()). buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageVIEWSUPPLY mv = new ManageVIEWSUPPLY();
        mv.selectAll();
    }
    public ObservableList<VIEW_SUPPLY> selectAll(){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<VIEW_SUPPLY> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List view_supply1 = session.createQuery("FROM VIEW_SUPPLY").list();
            for (Iterator iterator = view_supply1.iterator(); iterator.hasNext();) {
                list.add((VIEW_SUPPLY) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
