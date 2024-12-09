package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EventRepository;
import com.example.demo.entities.Event;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
	
	EventRepository eventRepository;

	@Override
	public Event addEvent(Event o) {
		return eventRepository.save(o);
	}

	@Override
	public void deleteEvent(Long id) {
		 eventRepository.deleteById(id);
		
	}

	@Override
	public Event updateEvent(Event p) {
		return eventRepository.saveAndFlush(p);
	}

	@Override
	public Event findEvent(Long id) {
		return eventRepository.findById(id).get();
	}

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}
	@Override
	public List<Event> findByTitre(String T) {
		return eventRepository.findByTitre(T);
	}
	
	@Override
	public List<Event> findByLieu(String L) {
		return eventRepository.findByLieu(L);
	}
	
}
