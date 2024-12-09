package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.service.IMemberService;
import com.example.demo.service.MemberImpl;

import lombok.AllArgsConstructor;


@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient


public class MemberServiceApplication implements CommandLineRunner {

	IMemberService MemberService;
	MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		EnseignantChercheur enseignant1 = EnseignantChercheur.builder()
				.cin("12398765")
				.nom("slim")
				.prenom("kenoun")
				.dateNaissance(new Date())
				.cv("CV slim")
				.email("slim.kenoun@example.com")
				.password("password1")
				.grade("Professeur")
				.etablissement("Univ A")
				.build();

		EnseignantChercheur enseignant2 = EnseignantChercheur.builder()
				.cin("56789123")
				.nom("tarak")
				.prenom("frikha")
				.dateNaissance(new Date())
				.cv("CV tarak")
				.email("tarak.frikha@example.com")
				.password("password2")
				.grade("Maître de conférences")
				.etablissement("Univ B")
				.build();
		memberRepository.save(enseignant1);
		memberRepository.save(enseignant2);


		Etudiant etudiant1 = Etudiant.builder()
				.cin("12398765")
				.nom("cherif")
				.prenom("abbes")
				.dateNaissance(new Date())
				.cv("CV cherif")
				.email("cherif.abbes@example.com")
				.password("password3")
				.dateInscription(new Date())
				.diplome("ingénieur")
				.build();

		Etudiant etudiant2 = Etudiant.builder()
				.cin("56789123")
				.nom("ala")
				.prenom("dammak")
				.dateNaissance(new Date())
				.cv("CV ala")
				.email("ala.dammak@example.com")
				.password("password4")
				.dateInscription(new Date())
				.diplome("master")
				.build();

		memberRepository.save(etudiant1);
		memberRepository.save(etudiant2);
		MemberService.affect_EtudianToEnseignant(etudiant1.getId(), enseignant1.getId());
		MemberService.affect_EtudianToEnseignant(etudiant2.getId(), enseignant1.getId());
		List<Etudiant> etds = MemberService.findByEncadrant(enseignant1);
		for (Etudiant member : etds) {
			System.out.println("Member with Id :"+ member.getCin()+ " and name " + member.getNom());
		}
		
		
		/**
		System.out.println("Liste des Members dans le laboratoire :");
		List<Member> members = memberRepository.findAll();
		
		for (Member member : members) {
			System.out.println("Member with Id :"+ member.getCin()+ " and name " + member.getNom());
		}


		Long idEtudiant1 = etudiant1.getId();
		Optional<Member> Member = memberRepository.findById(idEtudiant1);
		Member.ifPresentOrElse(
				m -> System.out.println("Member trouvé : " + m),
				() -> System.out.println("Member avec ID " + idEtudiant1 + " non trouvé.")
		);

		// Modifier un Member
		if (Member.isPresent()) {
			Member MemberAModifier = Member.get();
			MemberAModifier.setEmail("nouveau.email@example.com");
			memberRepository.save(MemberAModifier);
			System.out.println("Member modifié : " + MemberAModifier);
		}

		// Supprimer un Member
		Long idASupprimer = etudiant2.getId(); 
		memberRepository.deleteById(idASupprimer);
		System.out.println("Member avec ID " + idASupprimer + " supprimé.");
	    */
		
	}
}
