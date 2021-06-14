package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Receve;
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

       //TODO починить дату ниче не работает
        LocalDate date = LocalDate.of(2000,12,20);
        ManageReceve MR = new ManageReceve();
       // MR.addReceve(1,1,100,date,1);
       // MR.addReceve(3,3,200,date,1);
        //MR.listReceve();

        //MR.updateReceve(3,300);

        //MR.deleteReceve(2);

        MR.listReceve();
    }

    /* Method to CREATE an employee in the database */
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

    /* Method to  READ all the employees */
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

    /* Method to UPDATE salary for an employee */
    public void updateReceve(Integer receve_id, int ammount_rec ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Receve receve = (Receve) session.get(Receve.class, receve_id);
            receve.setAmmount_rec(ammount_rec);
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
