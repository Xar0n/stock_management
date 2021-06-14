package Controllers;

import POJO.Recevier;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ManageRecevier {
    private static SessionFactory factory;
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
//        MR.addRecevier("Рога и копыта","Ивана-Крузерштерна 25");
//        MR.addRecevier("Рога и неокопыта","Москва Пожарски 28");
//
//        MR.listRecevier();
//
//        MR.updateRecevier(1,"Сатана и другие");
//        MR.deleteRecevier(2);
//
//        MR.listRecevier();
//    }

    /* Method to CREATE an employee in the database */
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

    /* Method to  READ all the employees */
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

    /* Method to UPDATE salary for an employee */
    public void updateRecevier(Integer recevier_id, String name_recev ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Recevier recevier = (Recevier) session.get(Recevier.class, recevier_id);
            recevier.setName_recev(name_recev);
            session.update(recevier);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
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


    public static void setFactory(SessionFactory factory) {
        ManageRecevier.factory = factory;
    }

    public ManageRecevier() {
    }
}
