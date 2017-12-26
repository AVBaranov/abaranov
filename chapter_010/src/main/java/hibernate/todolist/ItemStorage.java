package hibernate.todolist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 07.12.2017.
 */
public class ItemStorage {

    public ItemStorage() {
    }

    public List<Item> getAll() {
        SessionFactory factory = null;
        Session session = null;
        List<Item> items = new CopyOnWriteArrayList<>();
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            items = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        return items;
    }

    public void add(Item item) {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            session.beginTransaction();
            Item it = new Item();
            it.setId(item.getId());
            it.setDescr(item.getDescr());
            it.setCreated(item.getCreated());
            it.setDone(item.getDone());
            session.saveOrUpdate(it);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

}
