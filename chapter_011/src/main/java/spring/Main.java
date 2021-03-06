package spring;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean_creation.AppConfig;
import spring.bean_creation.SomeInterfaceImpl;
import spring.store.ImportUser;
import spring.store.User;

/**
 * Created by Andrey on 02.02.2018.
 */
public class Main {
    public static void main (String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ImportUser iu = (ImportUser) context.getBean("importuser");
        iu.add(new User("1", "1", "1"));
        System.out.println(iu.getAll());*/
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ((SomeInterfaceImpl)context.getBean("someImpl")).show();
    }
}
