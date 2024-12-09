package com.example.demo.entities;

import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("etd")

public class Etudiant extends Member {
	@NonNull
	private String diplome;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	@ManyToOne
	private EnseignantChercheur encadrant;

	@Builder
	public Etudiant(String cin, String nom, String prenom, Date dateNaissance, String cv, String email, String password,
			Date dateInscription, String diplome, EnseignantChercheur encadrant) {
		super(cin, nom, prenom, dateNaissance, cv, email, password);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}

}