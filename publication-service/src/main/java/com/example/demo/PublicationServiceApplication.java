package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class PublicationServiceApplication implements CommandLineRunner {

    private final IPublicationService publicationService;

    public static void main(String[] args) {
        SpringApplication.run(PublicationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Adding sample publications
        Publication publication1 = Publication.builder()
                .type("Article")
                .titre("Spring Boot Fundamentals")
                .lien("https://example.com/spring-boot")
                .date(new Date())
                .sourcepdf("spring-boot-fundamentals.pdf")
                .build();

        Publication publication2 = Publication.builder()
                .type("Book")
                .titre("Microservices Architecture")
                .lien("https://example.com/microservices")
                .date(new Date())
                .sourcepdf("microservices-architecture.pdf")
                .build();

        publicationService.addPublication(publication1);
        publicationService.addPublication(publication2);

        // Retrieving all publications
        List<Publication> allPublications = publicationService.findAllPublications();
        System.out.println("All Publications:");
        allPublications.forEach(pub -> System.out.println(pub.getTitre()));

        // Searching by title
        String searchTitle = "Spring Boot Fundamentals";
        List<Publication> publicationsByTitle = publicationService.findPublicationsByTitre(searchTitle);
        System.out.println("\nPublications with title '" + searchTitle + "':");
        publicationsByTitle.forEach(pub -> System.out.println(pub.getTitre()));

        // Searching by type
        String searchType = "Article";
        List<Publication> publicationsByType = publicationService.findPublicationsByType(searchType);
        System.out.println("\nPublications of type '" + searchType + "':");
        publicationsByType.forEach(pub -> System.out.println(pub.getTitre()));

        // Updating a publication
        if (!allPublications.isEmpty()) {
            Publication pubToUpdate = allPublications.get(0);
            pubToUpdate.setTitre("Updated Title: " + pubToUpdate.getTitre());
            publicationService.updatePublication(pubToUpdate);
            System.out.println("\nUpdated Publication:");
            System.out.println(publicationService.findPublicationById(pubToUpdate.getId()));
        }

        // Deleting a publication
        if (!allPublications.isEmpty()) {
            Long idToDelete = allPublications.get(1).getId();
            publicationService.deletePublication(idToDelete);
            System.out.println("\nDeleted Publication with ID: " + idToDelete);
        }

        // Displaying all remaining publications
        System.out.println("\nRemaining Publications:");
        publicationService.findAllPublications().forEach(pub -> System.out.println(pub.getTitre()));
    }
}
