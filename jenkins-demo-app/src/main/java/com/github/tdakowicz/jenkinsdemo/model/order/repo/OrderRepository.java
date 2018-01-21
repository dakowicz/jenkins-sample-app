package com.github.tdakowicz.jenkinsdemo.model.order.repo;

import com.github.tdakowicz.jenkinsdemo.model.order.domain.Order;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

	Set<Order> findByDescription(String description);
}
