package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Outil;
import com.example.demo.service.IOutilService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class OutilServiceApplication implements CommandLineRunner {

    private final IOutilService outilService;

    public static void main(String[] args) {
        SpringApplication.run(OutilServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add Outils
        Outil outil1 = Outil.builder()
                .date(new Date())
                .source("https://example.com/tool1")
                .build();

        Outil outil2 = Outil.builder()
                .date(new Date())
                .source("https://example.com/tool2")
                .build();

        outilService.addOutil(outil1);
        outilService.addOutil(outil2);
    }}