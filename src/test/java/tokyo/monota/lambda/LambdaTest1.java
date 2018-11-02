package tokyo.monota.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class LambdaTest1 {

	@Test
	void testClosure() {
		
		Function<Double, Double> taxCalculator1 = createTaxCalculator1();
		Function<Double, Double> taxCalculator2 = createTaxCalculator2();
		
		// どちらも税率 8 % で計算されて、同じ結果になる。
		assertEquals(Double.valueOf(108.00), taxCalculator1.apply(100.00));
		assertEquals(Double.valueOf(108.00), taxCalculator2.apply(100.00));
		
		// インスタンス変数の値を変更すると、結果が変わる。
		outerTaxRate = 0.10;
		assertEquals(Double.valueOf(108.00), taxCalculator1.apply(100.00));
		assertEquals(Double.valueOf(110.00), taxCalculator2.apply(100.00));
	}
	
	Function<Double, Double> createTaxCalculator1() {
		// taxRate は実質的 final になるため変更できない。
		double taxRate = 0.08;
		return price -> price + price * taxRate;
	}
	
	double outerTaxRate = 0.08;
	Function<Double, Double> createTaxCalculator2() {
		// メソッドの外側にあるプロパティは final である必要はない。
		return price -> price + price * outerTaxRate;
	}
}
