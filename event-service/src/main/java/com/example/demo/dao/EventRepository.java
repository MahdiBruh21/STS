package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByTitre(String titre);

	List<Event> findByLieu(String lieu);
}
