package com.github.tdakowicz.jenkinsdemo.model.car.repo

import com.github.tdakowicz.jenkinsdemo.BaseIntegrationTest
import com.github.tdakowicz.jenkinsdemo.model.car.domain.Car
import org.springframework.beans.factory.annotation.Autowired

import javax.transaction.Transactional
import java.time.LocalDateTime

class CarRepositoryTest extends BaseIntegrationTest {

	static final LocalDateTime NOW = LocalDateTime.now()

	@Autowired
	CarRepository carRepository

	@Transactional
	def "should save a car entity"() {
		given:
		Car car = new Car()
		car.model = "ABC"
		car.modelId = 1234L
		car.manufactureDate = NOW

		when:
		carRepository.save(car)

		then:
		def cars = carRepository.findAll()
		cars
		cars.size() == 1
		with(cars.first()) {
			model == "ABC"
			modelId == 1234L
			manufactureDate == NOW
		}
	}

	@Transactional
	def "should find car by model"() {
		given:
		Car car = new Car(model: 'ABC', modelId: 1234L, manufactureDate: NOW)
		carRepository.save(car)

		when:
		def cars = carRepository.findByModel('ABC')

		then:
		cars
		cars.size() == 1
		with(cars.first()) {
			model == 'ABC'
			modelId == 1234L
			manufactureDate == NOW
		}
	}
}
