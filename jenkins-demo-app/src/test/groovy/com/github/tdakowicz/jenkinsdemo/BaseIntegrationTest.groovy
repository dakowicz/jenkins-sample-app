package com.github.tdakowicz.jenkinsdemo

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ContextConfiguration
@DataJpaTest
class BaseIntegrationTest extends Specification {

	@PersistenceContext
	protected EntityManager entityManager
}
