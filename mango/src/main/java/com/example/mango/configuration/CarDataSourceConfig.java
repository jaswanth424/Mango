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
        entityManagerFactoryRef = "carEntityManagerFactory",
        transactionManagerRef = "carTransactionManager"
)
public class CarDataSourceConfig {

    @Bean(name = "carDataSourceProperties")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "carDataSource")
    public DataSource dataSource(@Qualifier("carDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "carEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("carDataSource") DataSource dataSource,
            @Qualifier("carHibernateProperties") HibernateProperties hibernateProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.mango.model")
                .persistenceUnit("car")
                .properties(hibernateProperties.determineHibernateProperties(null, null))
                .build();
    }

    @Bean(name = "carTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("carEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(name = "carHibernateProperties")
    public HibernateProperties hibernateProperties() {
        return new HibernateProperties();
    }
}
