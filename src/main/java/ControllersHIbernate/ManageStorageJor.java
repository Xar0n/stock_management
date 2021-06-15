package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Storage;
import POJO.Storage_jor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;


public class ManageStorageJor extends ControllerHIbernate {
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
//        ManageStorageJor MSJ = new ManageStorageJor();
//
//        MSJ.addStorageJor(1,3,100,200,150);
//        MSJ.addStorageJor(3,2,100,200,150);
//
//        MSJ.updateStorages_jor(2,1);
//
//        MSJ.listStorages_jor();
//
//        MSJ.addStorageJor(1,5,100,200,150);
//    }

    /* Method to CREATE an employee in the database */
    public Integer addStorageJor(int id_product, int id_storage, int ammount, float price_in_sup,float price_in_sale){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer storage_jor_id = null;

        try {
            tx = session.beginTransaction();
            Storage_jor storages_jor = new Storage_jor(id_product, id_storage,ammount,price_in_sup,price_in_sale);
            storage_jor_id = (Integer) session.save(storages_jor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return storage_jor_id;
    }

    /* Method to  READ all the employees */
    public void listStorages_jor( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List storages = session.createQuery("FROM Storage_jor").list();
            for (Iterator iterator = storages.iterator(); iterator.hasNext();){
                Storage_jor storage_jor = (Storage_jor) iterator.next();
                System.out.println(storage_jor.getAmount());
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

    public ObservableList<Storage_jor> selectByIdStorage(int id_storage){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<Storage_jor> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List storages = session.createQuery("Select e from Storage_jor e where e.id_storage =:id_storage").
                    setParameter("id_storage", id_storage).list();
            for (Iterator iterator = storages.iterator(); iterator.hasNext();){
                list.add((Storage_jor) iterator.next());
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

    /* Method to UPDATE salary for an employee */
    public void updateStorages_jor(Integer Storage_jor_ID, Integer id_product, Integer id_storage, Integer amount, Float price_in_sup, Float price_in_sale ){ //TODO расширить до необходимого
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Storage_jor storage_jor = (Storage_jor) session.get(Storage_jor.class, Storage_jor_ID);
            storage_jor.setId_product(id_product);
            storage_jor.setId_storage(id_storage);
            storage_jor.setAmount(amount);
            storage_jor.setPrice_in_sup(price_in_sup);
            storage_jor.setPrice_in_sale(price_in_sale);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteStorage(Integer Storage_jor_ID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Storage_jor storage_jor = (Storage_jor) session.get(Storage_jor.class, Storage_jor_ID);
            session.delete(storage_jor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageStorageJor() {
    }
}
