package com.github.tdakowicz.jenkinsdemo.model.car.repo

import spock.lang.Specification

class DumbCarRepositoryTest extends Specification {

	def "should find order by description"() {
		when:
		def cars = new DumbOrderRepository().findByModel('ABC')

		then:
		cars
		cars.size()
		cars.first().model == 'ABC'
	}
}
