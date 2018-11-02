package tokyo.monota.comp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OrderTest {

	@Test
	public void testOrder() {
		
		List<OrderEntity> expects = new ArrayList<>();
		{
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("O_001");
			entity.setCustomerId("C_001");
			expects.add(entity);
		}
		{
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("O_002");
			entity.setCustomerId("C_005");
			expects.add(entity);
		}
		{
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("O_003");
			entity.setCustomerId("C_002");
			expects.add(entity);
		}
		
		// Use dummy data.
		List<OrderEntity> actuals = getOrderEntities();
		
		Optional<ComparatorStore> comparatorStore = ComparatorStore.findComparator(OrderEntity.class);
		List<OrderEntity> actualsSorted = new ArrayList<>(actuals);
		actualsSorted.sort(comparatorStore.get().getComparator());
		
		assertEquals(expects, actualsSorted);
	}
	
	List<OrderEntity> getOrderEntities() {
		
		List<OrderEntity> actuals = new ArrayList<>();
		{
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("O_001");
			entity.setCustomerId("C_001");
			actuals.add(entity);
		}
		{
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("O_002");
			entity.setCustomerId("C_005");
			actuals.add(entity);
		}
		{
			OrderEntity entity = new OrderEntity();
			entity.setOrderId("O_003");
			entity.setCustomerId("C_002");
			actuals.add(entity);
		}
		Collections.shuffle(actuals);
		return actuals;
	}
}
