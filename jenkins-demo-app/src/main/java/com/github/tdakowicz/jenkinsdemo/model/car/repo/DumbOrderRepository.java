package com.github.tdakowicz.jenkinsdemo.model.car.repo;

import com.github.tdakowicz.jenkinsdemo.model.car.domain.Car;
import java.util.HashSet;
import java.util.Set;

class DumbOrderRepository {

	public Set<Car> findByModel(String model) {
		Car car = new Car();
		car.setModel(model);
		HashSet<Car> cars = new HashSet<>();
		cars.add(car);
		return cars;
	}
}
