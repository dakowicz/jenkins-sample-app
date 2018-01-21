package com.github.tdakowicz.jenkinsdemo.model.order.repo;

import com.github.tdakowicz.jenkinsdemo.model.order.domain.Order;
import java.util.HashSet;
import java.util.Set;

class DumbOrderRepository {

	public Set<Order> findByDescription(String description) {
		Order order = new Order();
		order.setDescription(description);
		HashSet<Order> orders = new HashSet<>();
		orders.add(order);
		return orders;
	}
}
