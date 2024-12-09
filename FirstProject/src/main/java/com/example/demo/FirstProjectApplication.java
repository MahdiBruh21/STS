package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.HelloBean;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner{
@Autowired
HelloBean bean;
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(bean.getMessage(" from the other side!"));
		
	}

}

