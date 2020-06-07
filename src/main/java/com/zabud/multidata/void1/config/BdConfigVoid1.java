package com.zabud.multidata.void1.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory1",
transactionManagerRef = "transactionManager1",
    basePackages = {"com.zabud.multidata.void1.repo"})
public class BdConfigVoid1 {
  
  @Autowired
  Environment env;

  @Primary
  @Bean(name = "dataSource1")
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("void1.datasource.driver-class-name"));
    dataSource.setUrl(env.getProperty("void1.datasource.url"));
    dataSource.setUsername(env.getProperty("void1.datasource.username"));
    dataSource.setPassword(env.getProperty("void1.datasource.password"));
    return dataSource;
  }

  @Primary
  @Bean(name = "entityManagerFactory1")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("dataSource1") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.zabud.multidata.void1.domain")
        .persistenceUnit("void1").build();
  }

  @Primary
  @Bean(name = "transactionManager1")
  public PlatformTransactionManager transactionManager(
      @Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
