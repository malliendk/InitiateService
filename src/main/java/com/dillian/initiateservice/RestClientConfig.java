package com.dillian.initiateservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Component
public class RestClientConfig {

    @Bean
    public RestClient RestClient() {
        return RestClient
                .builder()
                .build();
    }
}
