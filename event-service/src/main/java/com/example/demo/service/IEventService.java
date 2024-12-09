package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Event;

public interface IEventService  {
	public Event addEvent(Event o);
	public void deleteEvent(Long id) ;
	public Event updateEvent(Event p) ;
	public Event findEvent(Long id) ;
	public List<Event> findAll();
	List<Event> findByTitre(String T);
	List<Event> findByLieu(String L);
}
