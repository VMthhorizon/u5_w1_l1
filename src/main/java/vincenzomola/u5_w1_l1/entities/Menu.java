package vincenzomola.u5_w1_l1.entities;

import java.util.List;

public class Menu {

    private List<Pizza> pizze;
    private List<Drink> drinks;

    public Menu(List<Pizza> pizze, List<Drink> drinks) {
        this.pizze = pizze;
        this.drinks = drinks;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Pizza> getPizze() {
        return pizze;
    }

    public void stampaMenu() {
        System.out.println("\n======= IL MENU DELLA PIZZERIA =======");
        System.out.println("\n--- PIZZE ---");
        pizze.forEach(System.out::println);

        System.out.println("\n--- BEVANDE ---");
        drinks.forEach(System.out::println);
        System.out.println("======================================");
    }
}
