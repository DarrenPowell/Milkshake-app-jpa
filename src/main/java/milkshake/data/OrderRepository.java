package milkshake.data;

import org.springframework.data.repository.CrudRepository;

import milkshake.Order;

public interface OrderRepository 
	 extends CrudRepository<Order, Long> {

	 }


