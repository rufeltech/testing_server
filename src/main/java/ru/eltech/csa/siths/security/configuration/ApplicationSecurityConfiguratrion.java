package ru.eltech.csa.siths.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguratrion extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationProvider authenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.authenticationProvider(authenticationProvider);
    }

  	@Override
  	protected void configure(HttpSecurity http) throws Exception {
        http
        	.formLogin()
        		.loginPage("/account/login")
        		.permitAll()
        		.and()
        	.logout()
        		.logoutUrl("/account/logout")
        		.permitAll()
        		.and()
        	.authorizeRequests()	
	        	.antMatchers("/account/create").anonymous()
	        	.antMatchers("/css/**").permitAll()
	        	.antMatchers("/fonts/**").permitAll()
	        	.antMatchers("/image/**").permitAll()
	        	.antMatchers("/js/**").permitAll()
	        	.antMatchers("/admin/**").hasRole("ADMIN")
	        	.anyRequest().authenticated();
  	}
}