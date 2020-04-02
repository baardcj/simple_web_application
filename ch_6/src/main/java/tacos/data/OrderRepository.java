package tacos.data;

import tacos.Order;

import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Long> {
	
	
	/*
	 * Customizing JPA repositories 
	 * Examples of queries by domain specific language (DSL) of JPA
	 */
	/*
	List<Order> findByDeliveryZip(String deliveryZip);
	
	List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
	
	List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);
	
	List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
	
	@Query("Order o where o.deliveryCity='Seattle'")
	List<Order> readOrdersDeliveredInSeattle(); */ 
}