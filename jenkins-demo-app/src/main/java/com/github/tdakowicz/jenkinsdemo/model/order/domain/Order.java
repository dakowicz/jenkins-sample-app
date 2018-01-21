package com.github.tdakowicz.jenkinsdemo.model.order.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER")
@Data
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	private String description;

	private LocalDateTime orderDate;

	private Long productId;
}
