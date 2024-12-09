package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.entities.Publication;

public interface IPublicationService {
	

	public Publication addPublication(Publication publication) ;

	public Publication updatePublication(Publication publication) ;

	public void deletePublication(Long id) ;

	public Publication findPublicationById(Long id) ;

	public List<Publication> findAllPublications() ;

	public List<Publication> findPublicationsByTitre(String titre) ;
	public List<Publication> findPublicationsByType(String type) ;

	public List<Publication> findPublicationsByLien(String lien) ;
}
