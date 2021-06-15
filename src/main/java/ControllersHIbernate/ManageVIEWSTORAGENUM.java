package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.VIEW_RECEVE;
import POJO.VIEW_STORAGE_NUM;
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

public class ManageVIEWSTORAGENUM extends ControllerHIbernate {
    public ManageVIEWSTORAGENUM() {
    }
//        public static void main(String[] args) { //:TODO удалить тестовый блок
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
//        ManageVIEWSTORAGENUM MV = new ManageVIEWSTORAGENUM();
//        MV.selectAll();
//    }
    public ObservableList<VIEW_STORAGE_NUM> selectAll(){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<VIEW_STORAGE_NUM> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List viewStorageNum = session.createQuery("FROM VIEW_STORAGE_NUM").list();
            for (Iterator iterator = viewStorageNum.iterator(); iterator.hasNext();) {
                list.add((VIEW_STORAGE_NUM) iterator.next());
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
