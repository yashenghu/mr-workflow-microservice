package com.medirecords.mrtemplatemicroservice.rest.sample.config;

import com.medirecords.autoconfiguration.AbstractOauth2ResourceServerConfiguration;
import com.medirecords.userinjection.MrAccessTokenConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

public class Oauth2ResourceServerMrAppConfigAdapter extends AbstractOauth2ResourceServerConfiguration {
    public Oauth2ResourceServerMrAppConfigAdapter(String checkTokenEndpointUrl, String clientId, String clientSecret,
            MrAccessTokenConverter mrAccessTokenConverter) {
        super(checkTokenEndpointUrl, clientId, clientSecret, mrAccessTokenConverter);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        super.configure(resources);
        resources.resourceId("api-mrapp");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.requestMatchers()
                .antMatchers("/v*/sample-api/api-mrapp/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
