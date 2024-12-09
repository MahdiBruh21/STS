package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.IHello;

@SpringBootApplication
public class Essai2024Application implements CommandLineRunner{
IHello h;
@Autowired
public Essai2024Application(IHello fr) {
this.h=fr;
}
public static void main(String[] args) {
SpringApplication.run(Essai2024Application.class, args);
}
public void run(String... args) throws Exception {
System.out.println("Hello Spring!!!! "+h.getMessage(" 	from ENIS"));
}
}