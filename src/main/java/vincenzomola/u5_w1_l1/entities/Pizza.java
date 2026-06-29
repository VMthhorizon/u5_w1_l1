package vincenzomola.u5_w1_l1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends MenuItem {
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nome, double prezzoBase, int calorieBase) {
        super(nome, prezzoBase, calorieBase);
    }

    public Pizza(String nome, double prezzoBase, int calorieBase, List<Topping> toppings) {
        super(nome, prezzoBase, calorieBase);
        this.toppings = new ArrayList<>(toppings);
    }

    @Override
    public double getPrezzo() {
        return super.getPrezzo() + toppings.stream()
                .mapToDouble(Topping::getPrezzo)
                .sum();
    }

    @Override
    public int getCalorie() {
        return super.getCalorie() + toppings.stream()
                .mapToInt(Topping::getCalorie)
                .sum();
    }

    @Override
    public String toString() {
        if (toppings.isEmpty()) {
            return super.toString() + " (Pomodoro, Mozzarella)";
        }
        String listaToppings = toppings.stream()
                .map(Topping::getNome)
                .collect(Collectors.joining(", "));
        return super.toString() + " (Base + " + listaToppings + ")";
    }
}
