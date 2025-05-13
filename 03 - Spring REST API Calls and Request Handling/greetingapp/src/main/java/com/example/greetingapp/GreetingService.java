package com.example.greetingapp;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class GreetingService {
    private final Map<Long, Greeting> greetings = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public String getSimpleGreetingMessage() {
        return "Hello World";
    }

    public Greeting getSimpleGreeting() {
        return new Greeting(counter.incrementAndGet(), getSimpleGreetingMessage());
    }

    public Greeting createGreeting(String firstName, String lastName) {
        String name = Arrays.asList(firstName, lastName)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" ")).trim();
        String msg = name.isEmpty() ? getSimpleGreetingMessage() : "Hello " + name;
        Greeting g = new Greeting(counter.incrementAndGet(), msg);
        greetings.put(g.getId(), g);
        return g;
    }

    public Greeting saveGreeting(Greeting greeting) {
        if (greeting.getId() == null) {
            greeting.setId(counter.incrementAndGet());
        }
        greetings.put(greeting.getId(), greeting);
        return greeting;
    }

    public Greeting findById(Long id) {
        return greetings.get(id);
    }

    public List<Greeting> findAll() {
        return new ArrayList<>(greetings.values());
    }

    public Greeting updateGreeting(Long id, Greeting newGreeting) {
        if (greetings.containsKey(id)) {
            newGreeting.setId(id);
            greetings.put(id, newGreeting);
            return newGreeting;
        }
        return null;
    }

    public void deleteGreeting(Long id) {
        greetings.remove(id);
    }
}
