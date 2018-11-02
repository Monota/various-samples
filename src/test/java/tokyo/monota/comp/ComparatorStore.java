package tokyo.monota.comp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public enum ComparatorStore {

	/** orderId でソートする OrderEntity の Comparator */
	ORDER_COMPARATOR(Comparator.comparing(OrderEntity::getOrderId), OrderEntity.class);
	
	Comparator<?> comparator;
	Class<?> entityClass;
	
	// T 指定により引数はどちらも同じ型をベースにしていることを示す。
	<T> ComparatorStore(Comparator<T> comparator, Class<T> entityClass) {
		this.comparator = comparator;
		this.entityClass = entityClass;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Comparator<T> getComparator() {
		return (Comparator<T>) this.comparator;
	}
	
	public static Optional<ComparatorStore> findComparator(Class<?> targetClass) {
		return Arrays.stream(ComparatorStore.values()).filter(comp -> comp.entityClass == targetClass).findAny();
	}
}
