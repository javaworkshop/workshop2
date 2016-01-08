/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.workshop2.floorinxs.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation
        .PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfigurer {
    @Autowired
    HikariDataSource hikariDataSource;
    @Autowired
    HibernateJpaDialect jpaDialect;
    @Autowired
    HibernateJpaVendorAdapter jpaVendorAdapter;
    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory;
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor postProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    private HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName("springHikariCP");
        //hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setDataSourceClassName(
                "com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikariConfig.addDataSourceProperty("url", 
                "jdbc:Mysql://localhost:3306/workshop2db");
        hikariConfig.addDataSourceProperty("user", "w2admin");
        hikariConfig.addDataSourceProperty("password", "w2admin");
        
        return hikariConfig;
    }
    
    @Bean
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource(hikariConfig());
    }
    
    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = 
                new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setDatabasePlatform(
                "org.hibernate.dialect.MySQLDialect");
        
        return jpaVendorAdapter;
    }
    
    @Bean
    public HibernateJpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = 
                new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan(
                new String[]{"org.workshop2.floorinxs.entity"});
        entityManagerFactory.setDataSource(hikariDataSource);
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactory.setJpaDialect(jpaDialect);
        
        return entityManagerFactory;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory
                .getObject());
        transactionManager.setDataSource(hikariDataSource);
        transactionManager.setJpaDialect(jpaDialect);
        
        return transactionManager;
    }
}
