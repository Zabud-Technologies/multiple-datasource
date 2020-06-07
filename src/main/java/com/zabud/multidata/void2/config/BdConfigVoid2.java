package com.zabud.multidata.void2.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory2",
transactionManagerRef = "transactionManager2",
    basePackages = {"com.zabud.multidata.void2.repo"})
public class BdConfigVoid2 {
  
  @Autowired
  Environment env;

  @Bean(name = "dataSource2")
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("void2.datasource.driver-class-name"));
    dataSource.setUrl(env.getProperty("void2.datasource.url"));
    dataSource.setUsername(env.getProperty("void2.datasource.username"));
    dataSource.setPassword(env.getProperty("void2.datasource.password"));
    return dataSource;
  }

  @Bean(name = "entityManagerFactory2")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("dataSource2") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.zabud.multidata.void2.domain")
        .persistenceUnit("void2").build();
  }

  @Bean(name = "transactionManager2")
  public PlatformTransactionManager transactionManager(
      @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
