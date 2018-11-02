package tokyo.monota.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class LambdaTest2 {

	@Test
	void testClosure() {
		
		Function<Double, Double> taxCalculator1 = createTaxCalculator1();
		Function<Double, Double> taxCalculator2 = createTaxCalculator2();
		
		// Ç«ÇøÇÁÇ‡ê≈ó¶ 8 % Ç≈åvéZÇ≥ÇÍÇƒÅAìØÇ∂åãâ Ç…Ç»ÇÈÅB
		assertEquals(Double.valueOf(108.00), taxCalculator1.apply(100.00));
		assertEquals(Double.valueOf(108.00), taxCalculator2.apply(100.00));
		
		assertEquals(9, outerTaxRate.get());

		// 
		assertEquals(Double.valueOf(109.00), taxCalculator1.apply(100.00));
		assertEquals(Double.valueOf(109.00), taxCalculator2.apply(100.00));
		
		assertEquals(10, outerTaxRate.get());
	}
	
	Function<Double, Double> createTaxCalculator1() {
		AtomicInteger taxRate = new AtomicInteger(8);
		return price -> {
			double newPrice = price + price * taxRate.get() / 100;
			taxRate.incrementAndGet();
			return newPrice;
		};
	}
	
	AtomicInteger outerTaxRate = new AtomicInteger(8);
	Function<Double, Double> createTaxCalculator2() {
		return price -> {
			double newPrice = price + price * outerTaxRate.get() / 100;
			outerTaxRate.incrementAndGet();
			return newPrice;
		};
	}
}
