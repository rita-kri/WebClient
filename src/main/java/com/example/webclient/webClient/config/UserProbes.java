package com.example.webclient.webClient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class UserProbes {
    private String baserurl;
}
