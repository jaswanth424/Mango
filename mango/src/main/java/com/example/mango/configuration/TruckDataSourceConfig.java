package com.example.mango.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.mango.repository",
        entityManagerFactoryRef = "truckEntityManagerFactory",
        transactionManagerRef = "truckTransactionManager"
)
public class TruckDataSourceConfig {

    @Bean(name = "truckDataSourceProperties")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "truckDataSource")
    public DataSource dataSource(@Qualifier("truckDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "truckEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("truckDataSource") DataSource dataSource,
            @Qualifier("truckHibernateProperties") HibernateProperties hibernateProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.mango.model")
                .persistenceUnit("truck")
                .properties(hibernateProperties.determineHibernateProperties(null, null))
                .build();
    }

    @Bean(name = "truckTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("truckEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "truckHibernateProperties")
    public HibernateProperties hibernateProperties() {
        return new HibernateProperties();
    }
}
