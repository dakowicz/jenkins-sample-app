package com.github.tdakowicz.jenkinsdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.sql.DataSource

@SpringBootTest
class ApplicationTest extends Specification {

	@Autowired
	DataSource dataSource

	def "should setup context"() {
		expect:
		true
	}
}
