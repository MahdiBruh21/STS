package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberImpl implements IMemberService{

	MemberRepository memberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository ensegniantChercheurRepository ; 
	@Override
	public Member addMember(Member m) {
		memberRepository.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	@Override
	public Member updateMember(Member p) {
		return memberRepository.saveAndFlush(p);	
	}
	
	@Override
	public Member findMember(Long id) {
		Member m = memberRepository.findById(id).get();
		return m;
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = memberRepository.findAll();
		return members;
	}
	@Override
	public Member findByCin(String cin) {
	    return memberRepository.findByCin(cin);
	}

	@Override
	public Member findByEmail(String email) {
	    return memberRepository.findByEmail(email);
	}

	@Override
	public List<Member> findByNom(String nom) {
	    return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
	    return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
	    return ensegniantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
	    return ensegniantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affect_EtudianToEnseignant(Long idEtudiant, Long idEnseignant) {
		Etudiant etd = etudiantRepository.findById(idEtudiant).get();
		EnseignantChercheur encadrant = ensegniantChercheurRepository.findById(idEnseignant).get();
		etd.setEncadrant(encadrant);
		memberRepository.save(etd);
		
	}
	@Override
	public List<Etudiant> findByEncadrant(EnseignantChercheur encadrant) {
	    return etudiantRepository.findByEncadrant(encadrant);
	}
	

}
