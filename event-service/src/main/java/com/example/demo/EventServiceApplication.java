package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Event;
import com.example.demo.service.IEventService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class EventServiceApplication implements CommandLineRunner {

    private final IEventService eventService;

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add Events
        Event event1 = Event.builder()
                .date(new Date())
                .titre("Spring Boot Workshop")
                .lieu("Conference Room A")
                .build();

        Event event2 = Event.builder()
                .date(new Date())
                .titre("Tech Talk")
                .lieu("Auditorium")
                .build();

        eventService.addEvent(event1);
        eventService.addEvent(event2);
        
    }}