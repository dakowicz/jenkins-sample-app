package com.github.tdakowicz.jenkinsdemo

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ContextConfiguration
@SpringBootTest
@ActiveProfiles(['test'])
class BaseIntegrationTest extends Specification {

	@PersistenceContext
	protected EntityManager entityManager
}
