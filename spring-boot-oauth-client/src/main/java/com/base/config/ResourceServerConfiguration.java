package com.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
@EnableResourceServer
@EnableOAuth2Client
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "restservice";

    @Autowired
    private OAuth2ClientContextFilter oauth2ClientContextFilter;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        // @formatter:off
        resources
            .resourceId(RESOURCE_ID);
        // @formatter:on
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests()
            .antMatchers("/secured/*").authenticated()
            .antMatchers("/employee/*").authenticated()
            .antMatchers("/auth/*").authenticated()
                .and()
                .addFilterAfter(oauth2ClientContextFilter, SecurityContextPersistenceFilter.class);
        // @formatter:on
    }

}
