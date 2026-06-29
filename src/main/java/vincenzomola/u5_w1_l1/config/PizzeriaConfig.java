package vincenzomola.u5_w1_l1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vincenzomola.u5_w1_l1.entities.Drink;
import vincenzomola.u5_w1_l1.entities.Menu;
import vincenzomola.u5_w1_l1.entities.Pizza;
import vincenzomola.u5_w1_l1.entities.Topping;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PizzeriaConfig {

    // --- BEANS TOPPINGS ---
    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 1.50, 110);
    }

    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 1.00, 50);
    }

    @Bean
    public Topping salamePiccante() {
        return new Topping("Salame Piccante", 1.80, 150);
    }

    // --- BEANS DRINKS ---
    @Bean
    public Drink cocaCola() {
        return new Drink("Coca Cola", 2.50, 140);
    }

    @Bean
    public Drink acqua() {
        return new Drink("Acqua Minerale", 1.50, 0);
    }

    // --- BEANS PIZZE ---
    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", 5.00, 800);
    }

    @Bean
    public Pizza diavola() {
        // Margherita + Salame Piccante
        return new Pizza("Diavola", 5.00, 800, List.of(salamePiccante()));
    }

    @Bean
    public Pizza hawaiianPizza() {
        // Margherita + Prosciutto + Ananas
        return new Pizza("Hawaiian Pizza", 5.00, 800, Arrays.asList(prosciutto(), ananas()));
    }

    @Bean
    public Pizza margheritaDoppioProsciutto() {
        // Dimostrazione del topping inserito due volte (Doppio Prosciutto)
        return new Pizza("Margherita Doppio Prosciutto", 5.00, 800, Arrays.asList(prosciutto(), prosciutto()));
    }

    // --- BEAN MENU ---
    @Bean
    public Menu pizzeriaMenu(List<Pizza> tutteLePizze, List<Drink> tuttiIDrinks) {
        return new Menu(tutteLePizze, tuttiIDrinks);
    }
}
