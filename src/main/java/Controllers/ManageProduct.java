package Controllers;

import Base.ControllerHIbernate;
import POJO.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ManageProduct extends ControllerHIbernate {
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
//        ManageProduct MP = new ManageProduct();
//        MP.addProduct("Рыба");
//        MP.addProduct("Карты");
//        MP.addProduct("Два ствола");
//
//        MP.deleteProduct(2);
//        MP.updateStorages_jor(1,"Деньги");
//        MP.listProduct();
//    }

    /* Method to CREATE an employee in the database */
    public Integer addProduct( String name_prod){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer product_id = null;

        try {
            tx = session.beginTransaction();
            Product product = new Product(name_prod);
            product_id = (Integer) session.save(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product_id;
    }

    /* Method to  READ all the employees */
    public void listProduct( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List product = session.createQuery("FROM Product").list();
            for (Iterator iterator = product.iterator(); iterator.hasNext();){
                Product products = (Product) iterator.next();
                System.out.println(products.getName_prod());
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
    public void updateProduct(Integer Product_id, String name_prod ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Product product = (Product) session.get(Product.class, Product_id);
            product.setName_prod(name_prod);
            session.update(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteProduct(Integer Product_ID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Product product = (Product) session.get(Product.class, Product_ID);
            session.delete(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ManageProduct() {
    }
}

