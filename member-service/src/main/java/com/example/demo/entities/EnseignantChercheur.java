package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Member {
	@NonNull
	private String grade;
	@NonNull
	private String etablissement;

	@Builder
	public EnseignantChercheur(String cin, String nom, String prenom, Date dateNaissance, String cv, String email,
			String password, Date dateInscription, String grade, String etablissement) {
		super(cin, nom, prenom, dateNaissance, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;

	}

}
