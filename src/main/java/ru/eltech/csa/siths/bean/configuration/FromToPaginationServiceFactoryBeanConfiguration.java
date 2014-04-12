package ru.eltech.csa.siths.bean.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.eltech.csa.siths.service.implementation.FromToPaginationServiceImpl;

@Configuration
public class FromToPaginationServiceFactoryBeanConfiguration {

	@Bean
	public FromToPaginationServiceImpl fromToPaginationService() {
		return new FromToPaginationServiceImpl(); //Pagination could be configured but not configured right now
	}

}