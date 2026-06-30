package vincenzomola.u5_w1_l1.entities;

import vincenzomola.u5_w1_l1.enums.StatoTavolo;

public class Tavolo {

    private int numero;
    private int maxCoperti;
    private StatoTavolo stato;

    public Tavolo(int numero, int maxCoperti, StatoTavolo stato) {
        this.numero = numero;
        this.maxCoperti = maxCoperti;
        this.stato = stato;
    }

    public StatoTavolo getStato() {
        return stato;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "numero=" + numero +
                ", maxCoperti=" + maxCoperti +
                ", stato=" + stato +
                '}';
    }
}
