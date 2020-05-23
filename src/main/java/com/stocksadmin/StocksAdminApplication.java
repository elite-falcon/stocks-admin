package com.stocksadmin;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.stocksadmin.storage.JPAPropertiesCreator;

@SpringBootApplication
public class StocksAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksAdminApplication.class, args);
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JPAPropertiesCreator jpaConfigurationCreator) {

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setPersistenceProvider(new HibernatePersistenceProvider());
		factory.setPackagesToScan("com.stocksadmin.model", "com.stocksadmin.persistence");
		factory.setPersistenceUnitName("persistence-unit");
		factory.setJpaPropertyMap(jpaConfigurationCreator.createJPAConfiguration());
		return factory;
	}
}
