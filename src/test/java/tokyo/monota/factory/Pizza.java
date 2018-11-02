package tokyo.monota.factory;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

	public enum Topping {
		HAM,
		MUSHROOM,
		ONION,
		PEPPER,
		SAUSAGE
	}
	
	final Set<Topping> toppings;
	
	// T �� BUILDER ���p�������N���X�B
	// BUILDER<T> �� T �͎q�N���X�Ōp�����Ɏ��M�̃N���X�� T �Ɏw�肷�邽�߂ɕK�v�B
	abstract static class Builder<T extends Builder<T>> {
		
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		// SELF ���\�b�h���q�N���X�� BUILDER ��Ԃ����� T �Ő錾���Ă���B
		public T addTopping(Topping topping) {
			
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		// SELF ���\�b�h���q�N���X�� BUILDER ��Ԃ����� T �Ő錾���Ă���B
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
	
	public Set<Topping> getToppings() {
		return Collections.unmodifiableSet(this.toppings);
	}
}
