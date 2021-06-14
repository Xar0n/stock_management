import Controllers.ManageStorage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionStart {
    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex); //TODO локализация ошибок
            throw new ExceptionInInitializerError(ex);
        }
        ManageStorage manageStorage = new ManageStorage();
        manageStorage.setFactory(factory);
        //manageStorage.addStorage("Нововеряпс","Новокузнецк Ленина 25");
        //manageStorage.updateStorages(1,"Иркутс Ленина 48");
    }

}
