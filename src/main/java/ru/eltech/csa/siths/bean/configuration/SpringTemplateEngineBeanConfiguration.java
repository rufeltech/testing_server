package ru.eltech.csa.siths.bean.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class SpringTemplateEngineBeanConfiguration {

	@Autowired
	ITemplateResolver templateResolver;

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(templateResolver);
        templateEngine.addDialect(new SpringSecurityDialect());

        return templateEngine;
    }

}