package vincenzomola.u5_w1_l1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import vincenzomola.u5_w1_l1.entities.*;
import vincenzomola.u5_w1_l1.enums.StatoTavolo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class U5W1L1ApplicationTests {


    @Test
    @DisplayName("Controlla numero di item nel menu è corretto")
    void testAddItemMenu() {
        System.out.println("TEST 1");
        Tavolo tavolo1 = new Tavolo(1, 4, StatoTavolo.OCCUPATO);
        Ordine ordine = new Ordine(1, tavolo1, 2);
        Pizza pizza1 = new Pizza("Margherita", 8, 200);
        Drink cola = new Drink("Cola", 2, 80);
        ordine.addMenuItem(pizza1);
        ordine.addMenuItem(cola);
        List<MenuItem> listaItem = ordine.getElementiMenu();
        int menuSize = listaItem.size();
        assertEquals(2, menuSize);
    }

    @ParameterizedTest
    @CsvSource({"20, 30, 150", "10,10,120"})
    @DisplayName("Testa la somma delle calorie dei toppings della pizza")
    void testCaloriesSum(int cal1, int cal2, int expectedResult) {
        Topping salame = new Topping("salame", 2, cal1);
        Topping mozzarella = new Topping("mozzarella", 3, cal2);
        List<Topping> allToppings = List.of(salame, mozzarella);
        Pizza pizza1 = new Pizza("Marinara", 10, 100, allToppings);
        assertEquals(expectedResult, pizza1.getCalorie());
    }
    

}
