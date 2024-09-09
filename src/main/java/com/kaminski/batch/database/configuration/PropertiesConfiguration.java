package com.kaminski.batch.database.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "auditoria.datasource")
public class PropertiesConfiguration {

    private String url;
    private String driverClassName;
    private String username;
    private String password;

}