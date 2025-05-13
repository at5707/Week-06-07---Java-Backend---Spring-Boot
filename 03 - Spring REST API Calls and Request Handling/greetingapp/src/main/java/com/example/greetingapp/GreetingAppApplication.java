package com.example.greetingapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(GreetingAppApplication.class);
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", "8086");
        app.setDefaultProperties(props);
        app.run(args);
    }
}
