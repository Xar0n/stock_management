package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Storage_jor;
import POJO.VIEW_RECEVE;
import POJO.VIEW_SUPPLY;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class ManageVIEWRECEVE extends ControllerHIbernate {
    public ManageVIEWRECEVE() {
    }
//    public static void main(String[] args) { //:TODO удалить тестовый блок
//
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
//                    configuration.getProperties()). buildServiceRegistry();
//            factory = configuration.buildSessionFactory(serviceRegistry);
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//        ManageVIEWRECEVE MV = new ManageVIEWRECEVE();
//        MV.selectAll();
//    }
        public ObservableList<VIEW_RECEVE> selectAll(){
            Session session = factory.openSession();
            Transaction tx = null;
            ObservableList<VIEW_RECEVE> list = FXCollections.observableArrayList();
            try {
                tx = session.beginTransaction();
                List viewReceve = session.createQuery("FROM VIEW_RECEVE").list();
                for (Iterator iterator = viewReceve.iterator(); iterator.hasNext();) {
                    list.add((VIEW_RECEVE) iterator.next());
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

    public ObservableList<VIEW_RECEVE> selectByIdStorage(int id_storage){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<VIEW_RECEVE> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List storages = session.createQuery("Select e from VIEW_RECEVE e where e.id_storage =:id_storage").
                    setParameter("id_storage", id_storage).list();
            for (Iterator iterator = storages.iterator(); iterator.hasNext();){
                list.add((VIEW_RECEVE) iterator.next());
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
