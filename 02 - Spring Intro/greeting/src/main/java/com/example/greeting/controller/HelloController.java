package com.example.greeting.controller;
import com.example.greeting.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/hello")
public class HelloController {
	// UC 1
    @GetMapping
    public String sayHello() {
        return "Hello from BridgeLabz";
    }

    // UC 2
    @GetMapping("/query")
    public String sayHelloQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC 3
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC 4
    @PostMapping("/post")
    public String sayHelloPost(@RequestBody UserDTO user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz";
    }

    // UC 5
    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}