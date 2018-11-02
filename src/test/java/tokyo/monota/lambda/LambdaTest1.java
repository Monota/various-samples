package tokyo.monota.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class LambdaTest1 {

	@Test
	void testClosure() {
		
		Function<Double, Double> taxCalculator1 = createTaxCalculator1();
		Function<Double, Double> taxCalculator2 = createTaxCalculator2();
		
		// �ǂ�����ŗ� 8 % �Ōv�Z����āA�������ʂɂȂ�B
		assertEquals(Double.valueOf(108.00), taxCalculator1.apply(100.00));
		assertEquals(Double.valueOf(108.00), taxCalculator2.apply(100.00));
		
		// �C���X�^���X�ϐ��̒l��ύX����ƁA���ʂ��ς��B
		outerTaxRate = 0.10;
		assertEquals(Double.valueOf(108.00), taxCalculator1.apply(100.00));
		assertEquals(Double.valueOf(110.00), taxCalculator2.apply(100.00));
	}
	
	Function<Double, Double> createTaxCalculator1() {
		// taxRate �͎����I final �ɂȂ邽�ߕύX�ł��Ȃ��B
		double taxRate = 0.08;
		return price -> price + price * taxRate;
	}
	
	double outerTaxRate = 0.08;
	Function<Double, Double> createTaxCalculator2() {
		// ���\�b�h�̊O���ɂ���v���p�e�B�� final �ł���K�v�͂Ȃ��B
		return price -> price + price * outerTaxRate;
	}
}
