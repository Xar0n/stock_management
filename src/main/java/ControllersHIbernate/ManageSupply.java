package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Receve;
import POJO.Supply;
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

public class ManageSupply extends ControllerHIbernate {
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
//
//        LocalDate date = LocalDate.of(2015,12,25);
//        ManageSupply MS = new ManageSupply();
//        MS.addSupply(1,1,205,date,1);
//        MS.addSupply(1,2,205,date,1);
//        MS.addSupply(1,3,205,date,1);
//
//        MS.listSupply();
//
//        MS.updateSupply(1,1,1,100,date,0);
//
//        MS.deleteSupply(2);
//
//        MS.listSupply();
//    }

    // Добавление поставщики
    public Integer addSupply(int id_suppliers, int id_js, int ammount_sup, LocalDate date_sup, int processed){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_supply = null;
        try {
            tx = session.beginTransaction();
            Supply supply = new Supply(id_suppliers,id_js,ammount_sup, Date.from(date_sup.atStartOfDay(ZoneId.systemDefault()).toInstant()),processed);
            id_supply = (Integer) session.save(supply);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id_supply;
    }

    //Дефолтный метод чтения
    public void listSupply( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List supply = session.createQuery("FROM Supply").list();
            for (Iterator iterator = supply.iterator(); iterator.hasNext();){
                Supply supplys = (Supply) iterator.next();
                System.out.println(supplys.getAmmount_sup());
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
    //Формирование дефолтной таблицы для поставщиков
    public ObservableList<Supply> selectAll( ){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<Supply> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List supply = session.createQuery("FROM Supply").list();
            for (Iterator iterator = supply.iterator(); iterator.hasNext();){
                list.add((Supply) iterator.next());
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
    //Стандартный метод обновления
    public void updateSupply(Integer supply_id,int id_suppliers,int id_sj ,int ammount_sup, LocalDate date_sup, int proccessed ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Supply supply = (Supply) session.get(Supply.class, supply_id);
            supply.setId_suppliers(id_suppliers);
            supply.setId_sj(id_sj);
            supply.setAmmount_sup(ammount_sup);
            supply.setDate_sup(Date.from(date_sup.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            supply.setProcessed(proccessed);
            session.update(supply);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //Дефолтное удаление
    public void deleteSupply(Integer Supply_ID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Supply supply = (Supply) session.get(Supply.class, Supply_ID);
            session.delete(supply);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageSupply() {
    }
}
