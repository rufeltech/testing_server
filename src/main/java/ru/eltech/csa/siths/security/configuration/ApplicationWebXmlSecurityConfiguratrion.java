package ru.eltech.csa.siths.security.configuration;

import org.springframework.security.web.context.*;

public class ApplicationWebXmlSecurityConfiguratrion extends AbstractSecurityWebApplicationInitializer {

    public ApplicationWebXmlSecurityConfiguratrion() {
        super(ApplicationSecurityConfiguratrion.class);
    }
}