package com.faiz.multiple.config.db;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory", basePackages = {
		"com.faiz.multiple.repo.book" }, transactionManagerRef = "bookTransactionManager")
public class BookDbConfig {

	@Bean(name = "bookDataSource")
	@ConfigurationProperties(prefix = "spring.book.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("bookDataSource") DataSource dataSource) {

		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return builder.dataSource(dataSource).properties(properties).packages("com.faiz.multiple.model.book")
				.persistenceUnit("Book").build();
	}

	@Bean(name = "bookTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
		return new JpaTransactionManager(bookEntityManagerFactory);
	}

}
