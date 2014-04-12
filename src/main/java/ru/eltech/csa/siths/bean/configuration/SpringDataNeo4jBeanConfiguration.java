package ru.eltech.csa.siths.bean.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.neo4j.config.JtaTransactionManagerFactoryBean;
import org.springframework.data.neo4j.support.Neo4jExceptionTranslator;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.mapping.Neo4jMappingContext;

import org.neo4j.graphdb.GraphDatabaseService;

@Configuration
public class SpringDataNeo4jBeanConfiguration {

    @Autowired
    GraphDatabaseService graphDatabaseService;

    @Bean
    public Neo4jTemplate neo4jTemplate() throws Exception {
        Neo4jTemplate template = new Neo4jTemplate(graphDatabaseService);

        return template;
    }

    @Bean
    public Neo4jMappingContext neo4jMappingContext() {
        return new Neo4jMappingContext();
    }

    @Bean
    public JtaTransactionManagerFactoryBean transactionManager() throws Exception {
        return new JtaTransactionManagerFactoryBean(graphDatabaseService);
    }

    @Bean
    public Neo4jExceptionTranslator exceptionTranslator() {
        return new Neo4jExceptionTranslator();
    }

}