package com.github.tdakowicz.jenkinsdemo.config;

import static com.github.tdakowicz.jenkinsdemo.config.DatabaseConfig.BASE_PACKAGE;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = BASE_PACKAGE)
public class DatabaseConfig {

	static final String BASE_PACKAGE = "com.github.tdakowicz";

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource odsDataSource) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(odsDataSource);
		lef.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lef.setPackagesToScan(BASE_PACKAGE);
		lef.setPersistenceUnitName("jenkins");
		return lef;
	}

	@Bean
	@Primary
	public EntityManagerFactory entityManagerFactory(LocalContainerEntityManagerFactoryBean lef) {
		return lef.getObject();
	}

	@Bean
	@Primary
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}
}
