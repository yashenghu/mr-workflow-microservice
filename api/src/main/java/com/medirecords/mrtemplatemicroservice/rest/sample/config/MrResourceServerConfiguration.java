package com.medirecords.mrtemplatemicroservice.rest.sample.config;

import com.medirecords.userinjection.MrAccessTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@ConditionalOnProperty(name = "mrapp-ms.oauth2.remote-token-check.enabled", havingValue = "custom")
public class MrResourceServerConfiguration {
    @Value("${mrapp-ms.oauth2.remote-token-check.check-token-url}")
    private String checkTokenEndpointUrl;

    @Value("${mrapp-ms.oauth2.remote-token-check.client-id}")
    private String clientId;

    @Value("${mrapp-ms.oauth2.remote-token-check.client-secret}")
    private String clientSecret;

    @Autowired
    private MrAccessTokenConverter mrAccessTokenConverter;

    @Bean
    public ResourceServerConfiguration apiOnlineAppointmentResourceServer(){
        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
            @Override
            public void setConfigurers(List<ResourceServerConfigurer> configurers) {
                super.setConfigurers(configurers);
            }
        };
        resource.setConfigurers(Arrays.asList(new Oauth2ResourceServerOnlineAPIConfigAdapter(checkTokenEndpointUrl,
                clientId, clientSecret, mrAccessTokenConverter)));
        resource.setOrder(10);
        return resource;
    }

    @Bean
    public ResourceServerConfiguration apiPatientPortalResourceServer(){
        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
            @Override
            public void setConfigurers(List<ResourceServerConfigurer> configurers) {
                super.setConfigurers(configurers);
            }
        };
        resource.setConfigurers(Arrays.asList(new Oauth2ResourceServerPatientPortalConfigAdapter(checkTokenEndpointUrl,
                clientId, clientSecret, mrAccessTokenConverter)));
        resource.setOrder(11);
        return resource;
    }

    @Bean
    public ResourceServerConfiguration apiMrappResourceServer(){
        ResourceServerConfiguration resource = new ResourceServerConfiguration() {
            @Override
            public void setConfigurers(List<ResourceServerConfigurer> configurers) {
                super.setConfigurers(configurers);
            }
        };
        resource.setConfigurers(Arrays.asList(new Oauth2ResourceServerMrAppConfigAdapter(checkTokenEndpointUrl,
                clientId, clientSecret, mrAccessTokenConverter)));
        resource.setOrder(12);
        return resource;
    }
}
