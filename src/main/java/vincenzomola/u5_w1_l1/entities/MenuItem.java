package vincenzomola.u5_w1_l1.entities;

public class MenuItem {

    private String nome;
    private double prezzo;
    private int calorie;

    public MenuItem(String nome, double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getCalorie() {
        return calorie;
    }

    @Override
    public String toString() {
        return String.format("%-30s | Calorie: %4d | Prezzo: %.2f€", nome, calorie, prezzo);
    }
}
