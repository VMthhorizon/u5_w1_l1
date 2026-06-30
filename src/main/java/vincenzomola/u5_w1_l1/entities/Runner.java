package vincenzomola.u5_w1_l1.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import vincenzomola.u5_w1_l1.enums.StatoTavolo;


public class Runner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Runner.class);

    private final Menu menu;
    private final double costoCoperto;

    public Runner(Menu menu, @Value("${pizzeria.costoCoperto}") double costoCoperto) {
        this.menu = menu;
        this.costoCoperto = costoCoperto;
    }

    ;

    @Override
    public void run(String... args) throws Exception {

        menu.stampaMenu();

        Tavolo tavolo3 = new Tavolo(3, 4, StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine(1, tavolo3, 2);

        ordine.addMenuItem(menu.getPizze()
                .get(0));
        ordine.addMenuItem(menu.getDrinks()
                .get(0));

        double totaleConto = ordine.total(this.costoCoperto);

        logger.info("=== RIEPILOGO ORDINE ===");
        logger.info("Ordine Numero: {}", ordine.getNumeroOrdine());
        logger.info("Tavolo Numero: {} (Stato: {})", tavolo3.getNumero(), tavolo3.getStato());
        logger.info("Numero Coperti: {}", ordine.getNumeroCoperti());
        logger.info("Stato attuale dell'ordine: {}", ordine.getStato());
        logger.info("TOTALE CONTO (inclusi {}€ di coperto a persona): {}€", this.costoCoperto, totaleConto);
        logger.info("========================");
    }
}
