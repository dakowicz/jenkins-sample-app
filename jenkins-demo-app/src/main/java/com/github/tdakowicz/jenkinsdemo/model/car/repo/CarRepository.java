package com.github.tdakowicz.jenkinsdemo.model.car.repo;

import com.github.tdakowicz.jenkinsdemo.model.car.domain.Car;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

	Set<Car> findByModel(String description);
}
