package org.ret.config;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;

import static org.ret.constant.AppConstant.DB_DRIVER;
import static org.ret.constant.AppConstant.DB_URL;
import static org.ret.constant.AppConstant.DB_USERNAME;
import static org.ret.constant.AppConstant.DB_PROPERTIES;

import java.util.Properties;

import static org.ret.constant.AppConstant.DB_PASSWORD;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
/*@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource(DB_PROPERTIES)
@ComponentScan("org.ret.entity")*/
public class DatabaseConfig {
    
    @Bean
    public DataSource createDataSource() throws Exception {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mls?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("mlsuser");
        dataSource.setPassword("mls123");

        return dataSource;
    }
    
/*    
    @Bean
    public DataSource dataSource(Environment environment) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getProperty(DB_DRIVER));
        dataSource.setUrl(environment.getProperty(DB_URL));
        dataSource.setUsername(environment.getProperty(DB_USERNAME));
        dataSource.setPassword(environment.getProperty(DB_PASSWORD));

        return dataSource;
    }
    
    @Bean
    @DependsOn("jdbcTemplate")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment environment) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource);

        entityManagerFactory.setPackagesToScan(environment.getProperty("entitymanager.packagesToScan"));

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        Properties additionalProperties =  new Properties();
        additionalProperties.put(DIALECT, environment.getProperty(DIALECT));
        additionalProperties.put(SHOW_SQL, environment.getProperty(SHOW_SQL));
        additionalProperties.put(USE_SECOND_LEVEL_CACHE, environment.getProperty(USE_SECOND_LEVEL_CACHE));
        entityManagerFactory.setJpaProperties(additionalProperties);
        
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
*/
    
}
