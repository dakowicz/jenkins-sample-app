package com.github.tdakowicz.jenkinsdemo.model.car.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CAR")
@Data
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue
	private Long id;

	private String model;

	private Long modelId;

	private LocalDateTime manufactureDate;
}
