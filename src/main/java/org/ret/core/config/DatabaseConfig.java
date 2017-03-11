package org.ret.core.config;

import static org.ret.core.constant.AppConstant.DB_DRIVER;
import static org.ret.core.constant.AppConstant.DB_URL;
import static org.ret.core.constant.AppConstant.DB_USERNAME;
import static org.ret.core.constant.AppConstant.DB_PASSWORD;

import java.net.URI;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
/*@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource(DB_PROPERTIES)
@ComponentScan("org.ret.entity")*/
public class DatabaseConfig {
    
    @Autowired
    private Environment environment;
    
    @Bean
    public DataSource createDataSource() throws Exception {
        
        URI dbUrl = new URI(environment.getProperty(DB_URL));
        String url = "jdbc:postgresql://" + dbUrl.getHost() + ":" + dbUrl.getPort() + dbUrl.getPath(); 
        String username = dbUrl.getUserInfo().split(":")[0];
        String password = dbUrl.getUserInfo().split(":")[1];
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(DB_DRIVER));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

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
