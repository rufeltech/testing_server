package ru.eltech.csa.siths.bean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.support.GraphDatabaseServiceFactoryBean;

import org.neo4j.graphdb.GraphDatabaseService;

@EnableTransactionManagement
@Configuration
@EnableNeo4jRepositories(basePackages = "ru.eltech.csa.siths.repository")
public class EmbeddedGraphDatabaseBeanConfiguration {
	
    private static final String DB_PATH = "target/neo4j/siths.db";

    @Bean
    public GraphDatabaseService graphDatabaseService() throws Exception {
        GraphDatabaseServiceFactoryBean graphDb = new GraphDatabaseServiceFactoryBean();

        graphDb.setPath(DB_PATH);

        return graphDb.getObject();
    }

}
