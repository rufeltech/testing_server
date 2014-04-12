package ru.eltech.csa.siths.bean.configuration;

import java.security.NoSuchAlgorithmException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.eltech.csa.siths.service.implementation.ObjectMessageDigestServiceImpl;

@Configuration
public class MD5ObjectMessageDigestBeanConfiguration {

    private final String algorithmName = "MD5";

    @Bean
    public ObjectMessageDigestServiceImpl md5ObjectMessageDigestService() throws NoSuchAlgorithmException {
        ObjectMessageDigestServiceImpl md5ObjectMessageDigestService 
        	= new ObjectMessageDigestServiceImpl(algorithmName);

        return md5ObjectMessageDigestService;
    }

}