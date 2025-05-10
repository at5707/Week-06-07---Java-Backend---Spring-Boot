package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DependencyInjection {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DependencyInjection.class);
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", 8083);
        app.setDefaultProperties(props);
        app.run(args);
	}
}