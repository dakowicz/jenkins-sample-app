package com.github.tdakowicz.jenkinsdemo

import com.github.tdakowicz.jenkinsdemo.model.order.domain.Order
import com.github.tdakowicz.jenkinsdemo.model.order.repo.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ContextConfiguration
@DataJpaTest
class SpringContextTest extends Specification {

	@PersistenceContext
	EntityManager entityManager

	@Autowired
	OrderRepository orderRepository

	@Autowired
	ApplicationContext applicationContext

	def "should setup spring context"() {
		expect:
		applicationContext != null
	}

	def "should save an order entity"() {
		given:
		Order order = new Order()
		order.description = "ABC"
		order.productId = 1234L

		when:
		orderRepository.save(order)
		entityManager.flush()

		then:
		def orders = orderRepository.findAll()
		orders.size() == 1
		with(orders.first()) {
			description == "ABC"
			productId == 1234L
		}
	}
}