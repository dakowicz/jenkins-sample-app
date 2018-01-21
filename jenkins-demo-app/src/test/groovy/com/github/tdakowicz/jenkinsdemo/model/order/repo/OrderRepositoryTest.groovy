package com.github.tdakowicz.jenkinsdemo.model.order.repo

import com.github.tdakowicz.jenkinsdemo.BaseIntegrationTest
import com.github.tdakowicz.jenkinsdemo.model.order.domain.Order
import org.springframework.beans.factory.annotation.Autowired

class OrderRepositoryTest extends BaseIntegrationTest {

	@Autowired
	OrderRepository orderRepository

	def "should save an order entity"() {
		given:
		Order order = new Order()
		order.description = "ABC"
		order.productId = 1234L

		when:
		orderRepository.save(order)

		then:
		def orders = orderRepository.findAll()
		orders
		orders.size() == 1
		with(orders.first()) {
			description == "ABC"
			productId == 1234L
		}
	}

	def "should find an order by description"() {
		given:
		Order order = new Order()
		order.description = "ABC"
		order.productId = 1234L
		orderRepository.save(order)

		when:
		def orders = orderRepository.findByDescription('ABC')

		then:
		orders
		orders.size() == 1
		with(orders.first()) {
			description == "ABC"
			productId == 1234L
		}
	}
}
