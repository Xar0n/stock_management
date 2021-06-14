package Base;

import Controllers.ManageRecevier;
import org.hibernate.SessionFactory;

public abstract class ControllerHIbernate {
    protected static SessionFactory factory;
    public static void setFactory(SessionFactory factory) {
        ControllerHIbernate.factory = factory;
    }
}
