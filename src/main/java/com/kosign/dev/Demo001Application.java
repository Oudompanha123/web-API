package com.kosign.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.kosign.dev.properties")
public class Demo001Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo001Application.class, args);
    }

}
