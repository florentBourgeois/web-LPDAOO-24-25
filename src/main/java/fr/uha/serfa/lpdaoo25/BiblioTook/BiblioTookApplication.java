package fr.uha.serfa.lpdaoo25.BiblioTook;

import fr.uha.serfa.lpdaoo25.BiblioTook.dao.AuteurRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.LivreRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.UsagerRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Bibliotheque;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import fr.uha.serfa.lpdaoo25.BiblioTook.utils.BibliothequeFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class BiblioTookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioTookApplication.class, args);
	}

	@Bean
	CommandLineRunner initRepos(AuteurRepository auteurRepo, UsagerRepository usagerRepo, LivreRepository livreRepository) {
		return args -> {
			System.out.println("\n\nInitialisation du projet\n---------------");
			Bibliotheque b = BibliothequeFactory.getBigBibliotheque();
			System.out.println(b.tousLesAuteurs());
			auteurRepo.saveAll(b.tousLesAuteurs());

			Livre l1 = livreRepository.findById(1L).get();
			Livre l2 = livreRepository.findById(2L).get();
			Livre l3 = livreRepository.findById(3L).get();

			Usager u1 = new Usager("Joe", "Joe",  LocalDate.of(1999,10,01));
			Usager u2 = new Usager("Usager2", "prenom",  LocalDate.of(1999,10,01));
			Usager u3 = new Usager("Usager3", "prenom3",  LocalDate.now());

			u1.setEmprunt(l1);
			u2.setEmprunt(l2);

			usagerRepo.save(u1);
			usagerRepo.save(u2);
			usagerRepo.save(u3);

			//System.out.println(usagerRepo.findDistinctByEmpruntNotNull());

			System.out.println(livreRepository.findAll());


			System.out.println("\n\nFIN \n---------------");
		};
	}

}
