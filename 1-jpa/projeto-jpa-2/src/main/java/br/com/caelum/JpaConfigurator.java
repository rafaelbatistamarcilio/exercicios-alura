package br.com.caelum;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

	@Bean(destroyMethod = "close")
	public DataSource getDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

	    dataSource.setDriverClass("org.postgresql.Driver");    
	    dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/projeto_jpa");
	    dataSource.setUser("alura");
	    dataSource.setPassword("alura");
	
	    dataSource.setMinPoolSize(3);
	    dataSource.setMaxPoolSize(5);
	    
	    //teste de conex�es ociosas
	    dataSource.setIdleConnectionTestPeriod(1);
	    
	    return dataSource;
	}
	
	@Bean
	public Statistics statistics(EntityManagerFactory emf) { 
	    return emf.unwrap(SessionFactory.class).getStatistics();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setPackagesToScan("br.com.caelum");
		entityManagerFactory.setDataSource(dataSource);

		entityManagerFactory
				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		
		//cache
		props.setProperty("hibernate.cache.use_second_level_cache", "true");
        props.setProperty("hibernate.cache.use_query_cache", "true");
        props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        
        //estat�sticas
        props.setProperty("hibernate.generate_statistics", "true");
		
        entityManagerFactory.setJpaProperties(props);
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

}
