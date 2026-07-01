package vincenzomola.u5_w1_l1.entities;

import vincenzomola.u5_w1_l1.enums.StatoOrdine;
import vincenzomola.u5_w1_l1.exceptions.WrongTypeException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    private Tavolo tavolo;
    private List<MenuItem> elementiMenu = new ArrayList<>();

    public Ordine(int numeroOrdine, Tavolo tavolo, int numeroCoperti) {
        this.numeroOrdine = numeroOrdine;
        this.tavolo = tavolo;
        this.numeroCoperti = numeroCoperti;
        this.stato = StatoOrdine.IN_CORSO;
        this.oraAcquisizione = LocalTime.now();
    }

    public void addMenuItem(MenuItem item) {
        if (item == null) throw new WrongTypeException("Il tipo dell'oggetto inserito NON E' VALIDO");
        this.elementiMenu.add(item);
    }

    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public int getNumeroCoperti() {
        return numeroCoperti;
    }

    public List<MenuItem> getElementiMenu() {
        return elementiMenu;
    }

    public double total(double coperto) {
        double totaleMenu = elementiMenu.stream()
                .mapToDouble(MenuItem::getPrezzo)
                .sum();
        double totaleCoperti = this.numeroCoperti * coperto;
        return totaleMenu + totaleCoperti;
    }

}
