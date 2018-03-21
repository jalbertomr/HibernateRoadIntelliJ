import org.bext.dto.Persona;
import org.bext.dto.Vehiculo;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        /*
        try {

            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
        */
        Persona persona = new Persona();
        persona.setName("Primera Persona");
        Persona persona2 = new Persona();
        persona2.setName("Segunda Persona");

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNombre("vehiculo one");
        Vehiculo vehiculo2 = new Vehiculo();
        vehiculo2.setNombre("vehiculo dos");

        session.beginTransaction();
        session.save(persona);
        session.save(persona2);
        session.save(vehiculo);
        session.save(vehiculo2);
        session.getTransaction().commit();

        session.close();
    }
}