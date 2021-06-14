package ControllersHIbernate;

import Base.ControllerHIbernate;
import POJO.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ManageStorage extends ControllerHIbernate {

    /* Method to CREATE an employee in the database */
    public Integer addStorage(String name, String address){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer storageID = null;

        try {
            tx = session.beginTransaction();
            Storage storages = new Storage(name, address);
            storageID = (Integer) session.save(storages);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return storageID;
    }

    /* Method to  READ all the employees */
    public void listStorages( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List storages = session.createQuery("FROM Storage").list();
            for (Iterator iterator = storages.iterator(); iterator.hasNext();){
                Storage storage = (Storage) iterator.next();
                System.out.print("Name: " + storage.getName());
                System.out.print("Address: " + storage.getAddress());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ObservableList<Storage> selectAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<Storage> list = FXCollections.observableArrayList();
        try {
            tx = session.beginTransaction();
            List storages = session.createQuery("FROM Storage").list();
            for (Iterator iterator = storages.iterator(); iterator.hasNext();){
                list.add((Storage) iterator.next());
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
    public void updateStorages(Integer StorageID, String address ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Storage storage = (Storage) session.get(Storage.class, StorageID);
            storage.setAddress(address);
            session.update(storage);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteStorage(Integer StorageID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Storage storage = (Storage) session.get(Storage.class, StorageID);
            session.delete(storage);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageStorage() {
    }
}
