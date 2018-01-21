package com.github.tdakowicz.jenkinsdemo

import com.github.tdakowicz.jenkinsdemo.model.order.repo.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class SpringContextTest extends BaseIntegrationTest {

	@Autowired
	OrderRepository orderRepository

	@Autowired
	ApplicationContext applicationContext

	def "should setup spring context"() {
		expect:
		applicationContext != null
	}
}