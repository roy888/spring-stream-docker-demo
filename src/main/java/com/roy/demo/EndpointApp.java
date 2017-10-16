package com.roy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@Configuration
@EnableCassandraRepositories
public class EndpointApp extends AbstractCassandraConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(EndpointApp.class, args);
    }

    @Override
    protected String getKeyspaceName() {
        return "demo";
    }

    @Bean
    @Lazy(value=true)
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster =
                new CassandraClusterFactoryBean();
        //cluster.setContactPoints("172.17.0.2");172.18.0.2
        cluster.setContactPoints("172.18.0.2");
        cluster.setPort(9042);
        cluster.setUsername("cassandra");
        cluster.setPassword("cassandra");
        return cluster;
    }

    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
