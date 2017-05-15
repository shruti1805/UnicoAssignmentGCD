package com.unico.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

/**
 * 
 * UnicoSecurity enables security features
 * 
 * @author Shruti Mahapatra
 *
 */

@Configuration
@EnableWebSecurity
public class UnicoSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.httpBasic().and().authorizeRequests()
			.antMatchers("/**").hasRole("USER")
			.and()
			.sessionManagement()
            .maximumSessions(20)
            .maxSessionsPreventsLogin(true)
            .sessionRegistry(sessionRegistry());
	}
	
	@Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("unico").password("unico1").roles("USER");
	}
}
