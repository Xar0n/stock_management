package Controllers;

import Base.ControllerHIbernate;
import POJO.Suppliers;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ManageSuppliers extends ControllerHIbernate {
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
//        ManageSuppliers MS = new ManageSuppliers();
//
//        MS.addSuppliers("Аве Вафли","Лондон улица 742");
//        MS.addSuppliers("Аве Цезарь","Рим Ромула 32");
//
//        MS.listSuppliers();
//
//        MS.updateSuppliers(1,"Сатор");
//
//        MS.deleteSuppliers(2);
//
//        MS.listSuppliers();
//    }

    /* Method to CREATE an employee in the database */
    public Integer addSuppliers( String name_sup, String address_sup){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id_suppliers = null;

        try {
            tx = session.beginTransaction();
            Suppliers suppliers = new Suppliers(name_sup,address_sup);
            id_suppliers = (Integer) session.save(suppliers);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id_suppliers;
    }

    /* Method to  READ all the employees */
    public void listSuppliers( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List suppliers = session.createQuery("FROM Suppliers").list();
            for (Iterator iterator = suppliers.iterator(); iterator.hasNext();){
                Suppliers supplier = (Suppliers) iterator.next();
                System.out.println(supplier.getName_sup());
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
    public void updateSuppliers(Integer suppliers_id, String name_sup ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Suppliers suppliers = (Suppliers) session.get(Suppliers.class, suppliers_id);
            suppliers.setName_sup(name_sup);
            session.update(suppliers);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteSuppliers(Integer Suppliers_ID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Suppliers suppliers = (Suppliers) session.get(Suppliers.class, Suppliers_ID);
            session.delete(suppliers);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageSuppliers() {
    }
}
