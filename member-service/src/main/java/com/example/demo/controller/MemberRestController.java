package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Member;
import com.example.demo.service.IMemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberRestController {
IMemberService memberService;

@RequestMapping(value="/Members", method=RequestMethod.GET)
public List<Member> findMembers (){
return memberService.findAll();
}

@GetMapping(value="/Members/{id}")
public Member findOneMemberById(@PathVariable Long id){
return memberService.findMember(id);
}

@GetMapping(value="/Members/search/cin")
public Member findOneMemberByCin(@RequestParam String cin)
{
return memberService.findByCin(cin);
}

@GetMapping(value="/Members/search/email")
public Member findOneMemberByEmail(@RequestParam String email)
{
return memberService.findByEmail(email);
}

@PostMapping(value="/Members/enseignant")
public Member addMember(@RequestBody EnseignantChercheur m)
{
return memberService.addMember(m);
}

@PostMapping(value="/Members/etudiant")
public Member addMember(@RequestBody Etudiant e)
{
return memberService.addMember(e);
}

@DeleteMapping(value="/Members/{id}")
public void deleteMember(@PathVariable Long id)
{
memberService.deleteMember(id);
}

@PutMapping(value="/Members/etudiant/{id}")
public Member updateMember(@PathVariable Long id, @RequestBody
Etudiant p)
{
p.setId(id);
return memberService.updateMember(p);
}

@PutMapping(value="/Members/enseignant/{id}")
public Member updateMember(@PathVariable Long id, @RequestBody
EnseignantChercheur p)
{
p.setId(id);
return memberService.updateMember(p);
}
}