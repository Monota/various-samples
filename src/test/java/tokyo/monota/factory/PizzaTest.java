package tokyo.monota.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PizzaTest {

	@Test
	public void testPizza() {
		
		// new するときにパラメータ化が不要なのは、継承時に型パラメータを指定しているため。
		NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.ONION).addTopping(Pizza.Topping.SAUSAGE).build();
		
		assertEquals(NyPizza.Size.SMALL, pizza.getSize());
		assertNotEquals(0, pizza.getToppings().size());
		assertTrue(pizza.getToppings().contains(Pizza.Topping.ONION));
		assertTrue(pizza.getToppings().contains(Pizza.Topping.SAUSAGE));
		assertFalse(pizza.getToppings().contains(Pizza.Topping.HAM));
		assertFalse(pizza.getToppings().contains(Pizza.Topping.PEPPER));
		assertFalse(pizza.getToppings().contains(Pizza.Topping.MUSHROOM));
	}
	
	@Test
	public void testCalzone() {

		// new するときにパラメータ化が不要なのは、継承時に型パラメータを指定しているため。
		Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauseInside().build();

		assertTrue(calzone.isSauceInside());
		assertNotEquals(0, calzone.getToppings().size());
		assertTrue(calzone.getToppings().contains(Pizza.Topping.HAM));
		assertFalse(calzone.getToppings().contains(Pizza.Topping.ONION));
		assertFalse(calzone.getToppings().contains(Pizza.Topping.PEPPER));
		assertFalse(calzone.getToppings().contains(Pizza.Topping.SAUSAGE));
		assertFalse(calzone.getToppings().contains(Pizza.Topping.MUSHROOM));
	}
}
