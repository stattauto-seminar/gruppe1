package de.stattauto.mitgliederverwaltung.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.stattauto.mitgliederverwaltung.entity.Mitglied;
import de.stattauto.mitgliederverwaltung.repository.MitgliedRepository;
import lombok.AllArgsConstructor;


@RefreshScope
@RestController
public class MitgliederverwaltungRestController {
	@Autowired
	private MitgliedRepository mitgliederRepo; //Wird übergeben durch Lombock
	
	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/member/{number}")
	public Collection<Mitglied> getMemberByKundenNummer(@PathVariable long number) {
		return mitgliederRepo.findByKundennummer(number);
	}
	@GetMapping("/member/id/{mitglied}") //Pathvariable wird als Long Übergeben! Spring macht daraus ein Mitglied Objekt
	public Mitglied getMemberByID(@PathVariable Mitglied mitglied) {
		return mitglied;
	}
	@GetMapping("/member")
	public Collection<Mitglied> getMemberByKundenNummer() {
		return mitgliederRepo.findAll();
	}
	@PostMapping("/member")
	public void addMember(@RequestBody Mitglied mitglied) {
		mitgliederRepo.save(mitglied);
	}
	@DeleteMapping("/member/{number}")
	public void deleteMember(@PathVariable Long number) {
		mitgliederRepo.deleteById(number);
	}
	@GetMapping("/hello")
	public String hello() {
		return message;
	}
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello "+name;
	}
}
