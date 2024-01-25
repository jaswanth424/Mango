package com.example.mango.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.mango.mango.model.Mango;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.mango.h2.repository"
					, entityManagerFactoryRef = "h2EntityManagerFactory"
					, transactionManagerRef = "h2TransactionManager")
public class H2DataSourceConfiguration {
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.h2")
	public DataSourceProperties h2DataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.h2")
	public HikariDataSource h2DataSource() {
		return h2DataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "h2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(h2DataSource()).packages("com.example.mango.mango.model").persistenceUnit("Mango").build();
	}

	@Primary
	@Bean(name = "h2TransactionManager")
	public PlatformTransactionManager h2TransactionManager(
			final @Qualifier("h2EntityManagerFactory") LocalContainerEntityManagerFactoryBean h2EntityManagerFactory) {
		return new JpaTransactionManager(h2EntityManagerFactory.getObject());
	}
}