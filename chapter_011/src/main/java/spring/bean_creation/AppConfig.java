package spring.bean_creation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Андрей on 06.02.2018.
 */
@Configuration
public class AppConfig {
    @Bean(name="someImpl")
    public SomeInterface getSomeInterface() {
        return new SomeInterfaceImpl();
    }
}
