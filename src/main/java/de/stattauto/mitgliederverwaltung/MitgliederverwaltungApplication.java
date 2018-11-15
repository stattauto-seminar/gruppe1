package de.stattauto.mitgliederverwaltung;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.stattauto.mitgliederverwaltung.entity.Mitglied;
import de.stattauto.mitgliederverwaltung.repository.MitgliedRepository;

@SpringBootApplication
@EnableJpaRepositories
public class MitgliederverwaltungApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitgliederverwaltungApplication.class, args);
	}
	@Bean
	CommandLineRunner init (MitgliedRepository mitgliedRepository) {
		return args -> {
			mitgliedRepository.save(new Mitglied(null,"Peter","Mueller",Math.round(Math.random()*100)));
			mitgliedRepository.save(new Mitglied(null,"Hans","Mueller",Math.round(Math.random()*100)));
			mitgliedRepository.save(new Mitglied(null,"Franz","Mueller",Math.round(Math.random()*100)));
		}; 
	} 
}
