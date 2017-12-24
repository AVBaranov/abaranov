package hibernate.todolist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Andrey on 21.12.2017.
 */
public class Main {
    public static void main (String[] args) {
//        ItemStorage.getInstance().add(new Item(1, "newitem", "21 december", true));
         SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setId(2);
        item.setDescr("newtest");
        item.setCreated("16:04564567");
        item.setDone(false);
        /*List<Item> items = session.createQuery("from Item").list();
        for (Item item : items) {
            System.out.println(item.getDescr());
        }*/
        session.save(item);


//        System.out.println(session.createQuery("from Item").list());
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
