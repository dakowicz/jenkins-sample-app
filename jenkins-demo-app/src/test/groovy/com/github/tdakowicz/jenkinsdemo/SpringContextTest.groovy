package com.github.tdakowicz.jenkinsdemo

import com.github.tdakowicz.jenkinsdemo.model.car.repo.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class SpringContextTest extends BaseIntegrationTest {

	@Autowired
	CarRepository orderRepository

	@Autowired
	ApplicationContext applicationContext

	def "should setup spring context"() {
		expect:
		applicationContext != null
	}
}