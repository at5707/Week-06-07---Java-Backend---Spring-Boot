package com.example.greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Map;
@SpringBootApplication
public class HelloMessagingApp {
	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HelloMessagingApp.class);
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", 8081);
        app.setDefaultProperties(props);

        app.run(args);
    }
}