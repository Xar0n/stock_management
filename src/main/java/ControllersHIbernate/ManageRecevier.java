package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Receve;
import POJO.Recevier;
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

public class ManageRecevier extends ControllerHIbernate {
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
//        ManageRecevier MR = new ManageRecevier();
//        MR.updateRecevier(3,"Малут","Новокузенцк Атера 725");
//        MR.listRecevier();
//    }

    //Добавление покупателей
    public Integer addRecevier( String name_recev, String address_recev){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_recevier = null;

        try {
            tx = session.beginTransaction();
            Recevier recevier = new Recevier(name_recev,address_recev);
            id_recevier = (Integer) session.save(recevier);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id_recevier;
    }

    //Тестовый вывод в консольку
    public void listRecevier( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List recevier = session.createQuery("FROM Recevier").list();
            for (Iterator iterator = recevier.iterator(); iterator.hasNext();){
                Recevier receviers = (Recevier) iterator.next();
                System.out.println(receviers.getName_recev());
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

    public ObservableList<Recevier> selectAll( ){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<Recevier> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List recevier = session.createQuery("FROM Recevier").list();
            for (Iterator iterator = recevier.iterator(); iterator.hasNext();){
                list.add((Recevier) iterator.next());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  list;
    }

    //Дефолтный апдейт
    public void updateRecevier(Integer recevier_id, String name_recev, String address_recev ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Recevier recevier = (Recevier) session.get(Recevier.class, recevier_id);
            recevier.setName_recev(name_recev);
            recevier.setAddress_recev(address_recev);
            session.update(recevier);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //удаление
    public void deleteRecevier(Integer Recevier_ID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Recevier recevier = (Recevier) session.get(Recevier.class, Recevier_ID);
            session.delete(recevier);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageRecevier() {
    }
}
