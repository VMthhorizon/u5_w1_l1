package vincenzomola.u5_w1_l1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import vincenzomola.u5_w1_l1.entities.Menu;

@SpringBootApplication
public class U5W1L1Application {

    public static void main(String[] args) {

        SpringApplication.run(U5W1L1Application.class, args);

        ApplicationContext context = SpringApplication.run(U5W1L1Application.class, args);

        Menu menuDellaPizzeria = context.getBean(Menu.class);

        menuDellaPizzeria.stampaMenu();
    }

}
