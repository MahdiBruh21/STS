package com.example.demo.service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;



import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublicationService implements IPublicationService {

	PublicationRepository publicationRepository;
	@Override
	public Publication addPublication(Publication publication) {
		return publicationRepository.save(publication);
	}

	@Override
	public Publication updatePublication(Publication publication) {
			return publicationRepository.saveAndFlush(publication);
	}

	@Override
	public void deletePublication(Long id) {
			publicationRepository.deleteById(id);		
	}

	

	@Override
	public List<Publication> findAllPublications() {
		return publicationRepository.findAll();
	}

	@Override
	public List<Publication> findPublicationsByTitre(String titre) {
		return publicationRepository.findByTitre(titre);
	}

	@Override
	public List<Publication> findPublicationsByType(String type) {
		return publicationRepository.findByType(type);
	}
	@Override
	public List<Publication> findPublicationsByLien(String lien) {
		return publicationRepository.findByLien(lien);
	}


	@Override
	public Publication findPublicationById(Long id) {
	
		return publicationRepository.findById(id).get();
	}

}
