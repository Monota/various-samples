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
	
	// T は BUILDER を継承したクラス。
	// BUILDER<T> の T は子クラスで継承時に自信のクラスを T に指定するために必要。
	abstract static class Builder<T extends Builder<T>> {
		
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		// SELF メソッドが子クラスの BUILDER を返すため T で宣言している。
		public T addTopping(Topping topping) {
			
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();
		
		// SELF メソッドが子クラスの BUILDER を返すため T で宣言している。
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
	
	public Set<Topping> getToppings() {
		return Collections.unmodifiableSet(this.toppings);
	}
}
