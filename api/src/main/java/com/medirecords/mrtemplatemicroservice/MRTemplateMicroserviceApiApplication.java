package com.medirecords.mrtemplatemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties
@PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
public class MRTemplateMicroserviceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MRTemplateMicroserviceApiApplication.class, args);
    }
}
