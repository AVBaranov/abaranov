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

        Item item = new Item();
        item.setId(11);
        item.setDescr("test");
        item.setCreated("20:23");
        item.setDone(false);
         SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        /*List<Item> items = session.createQuery("from Item").list();
        for (Item item : items) {
            System.out.println(item.getDescr());
        }*/
        session.save(item);
        item.setDescr("sdtgsdrg");
        item.setCreated("sdf");
        item.setDone(true);
//        session.update(item);
        session.getTransaction().commit();


//        System.out.println(session.createQuery("from Item").list());

        session.close();
        factory.close();
    }
}
