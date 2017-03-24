package com.jorgehernandezramirez.spring.springboot.ribbon.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name = "springcloudwebtest")
public class RibbonConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate buildRestTemplate(){
        return new RestTemplate();
    }
}
