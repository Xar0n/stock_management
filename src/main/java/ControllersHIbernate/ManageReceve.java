package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Receve;
import POJO.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ManageReceve extends ControllerHIbernate {
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
//        LocalDate date = LocalDate.of(2000,12,31);
//        ManageReceve MR = new ManageReceve();
//        MR.updateReceve(3,1,1,400,date,1);
//        MR.listReceve();
//    }

    // Добавление покупателей
    public Integer addReceve(int id_reciver, int id_js, int ammount_rec, LocalDate date_rec, int processed){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_receve = null;
        try {
            tx = session.beginTransaction();
            Receve receve = new Receve(id_reciver,id_js,ammount_rec,Date.from(date_rec.atStartOfDay(ZoneId.systemDefault()).toInstant()),processed);
            id_receve = (Integer) session.save(receve);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id_receve;
    }

    //Вывод покупателей в консоль
    public void listReceve( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List receve = session.createQuery("FROM Receve").list();
            for (Iterator iterator = receve.iterator(); iterator.hasNext();){
                Receve receves = (Receve) iterator.next();
                System.out.println(receves.getAmmount_rec());
                //TODO добавить вывод если нужно будет
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    //Формирование данных для дефолтной таблицы покупателей
    public ObservableList<Receve> selectAll( ){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<Receve> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List receve = session.createQuery("FROM Receve").list();
            for (Iterator iterator = receve.iterator(); iterator.hasNext();){
                list.add((Receve) iterator.next());
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

    //Обновления покупателей
    public void updateReceve(Integer receve_id,int id_recevier,int id_js, int ammount_rec, LocalDate date_rec, int processed){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Receve receve = (Receve) session.get(Receve.class, receve_id);
            receve.setId_reciver(id_recevier);
            receve.setId_js(id_js);
            receve.setAmmount_rec(ammount_rec);
            receve.setDate_rec(Date.from(date_rec.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            receve.setProcessed(processed);
            session.update(receve);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteReceve(Integer Receve_ID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Receve receve = (Receve) session.get(Receve.class, Receve_ID);
            session.delete(receve);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageReceve() {
    }
}
