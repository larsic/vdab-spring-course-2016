package com.realdolmen.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;

@Configuration
@Profile("test")
public class TestConfig {
    // TODO: Use this class to add an embedded datasource for the test profile (you will have to set this up yourself)

    @Bean
    public DataSource
    dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql").build();
    }
}
