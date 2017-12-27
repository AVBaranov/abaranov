package hibernate.todolist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 07.12.2017.
 */
public class ItemStorage {

    private SessionFactory factory = null;

    public ItemStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    public List<Item> getAll() {
        Session session = null;
        Transaction tx = null;
        List<Item> items = new CopyOnWriteArrayList<>();
        try {
            session = this.factory.openSession();
            tx = session.beginTransaction();
            items = session.createQuery("from Item").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
        }
        return items;
    }

    public void add(Item item) {
        Transaction tx = null;
        Session session = null;
        try {
            session = this.factory.openSession();
            session.beginTransaction();
            Item it = new Item();
            it.setId(item.getId());
            it.setDescr(item.getDescr());
            it.setCreated(item.getCreated());
            it.setDone(item.getDone());
            session.saveOrUpdate(it);
            session.getTransaction().commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            this.factory.close();
        }
    }

}
