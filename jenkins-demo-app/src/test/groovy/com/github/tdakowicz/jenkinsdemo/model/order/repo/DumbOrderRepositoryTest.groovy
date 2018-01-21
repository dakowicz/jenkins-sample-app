package com.github.tdakowicz.jenkinsdemo.model.order.repo

import spock.lang.Specification

class DumbOrderRepositoryTest extends Specification {

	def "should find order by description"() {
		when:
		def orders = new DumbOrderRepository().findByDescription('ABC')

		then:
		orders
		orders.size()
		orders.first().description == 'ABC'
	}
}
