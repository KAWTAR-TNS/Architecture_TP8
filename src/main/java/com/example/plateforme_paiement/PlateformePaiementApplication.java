package com.example.plateforme_paiement;

import com.example.plateforme_paiement.entities.Compte;
import com.example.plateforme_paiement.entities.TypeCompte;
import com.example.plateforme_paiement.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication(scanBasePackages = "com.example.plateforme_paiement")
public class PlateformePaiementApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlateformePaiementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository){
		return args -> {
			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));

			compteRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}