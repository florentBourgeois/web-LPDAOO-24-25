package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto.AuteurSecurise;
import fr.uha.serfa.lpdaoo25.BiblioTook.controller.dto.LivreAuteurSeulementNomDTO;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.AuteurRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.LivreRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.UsagerRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Auteur;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Bibliotheque;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import fr.uha.serfa.lpdaoo25.BiblioTook.utils.BibliothequeFactory;
import net.datafaker.Faker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * illustration d'un controlleur "utile" pour un projet
 */
@RestController
public class BibliotookController {

    private final AuteurRepository auteurRepo;
    private final LivreRepository livreRepository;
    private final UsagerRepository usagerRepository;

    public BibliotookController(AuteurRepository ar, LivreRepository lr, UsagerRepository ur) {
        this.auteurRepo = ar;
        this.livreRepository = lr;
        this.usagerRepository = ur;

        Faker f = new Faker();
        System.out.println(f.backToTheFuture().quote());
        System.out.println(f.artist().name());
        System.out.println(f.timeAndDate().birthday(20,500));

        BibliothequeFactory.addRandomBooksToBigBib(100);
    }


    /**
     * Renvoie la liste de tous els auteurs existant dans la BDD
     * @return
     */
    @GetMapping("/bibliotook/auteur")
    public List<Auteur> getAuteurs(){
        return this.auteurRepo.findAll();
    }

    @PostMapping("/bibliotook/auteur")
    public Auteur ajoutAuteurAleatoire(){
        Faker faker = new Faker();
        String nom = faker.onePiece().character();
        String prenom = faker.tron().character();
        LocalDate naissance = faker.timeAndDate().birthday(19, 500);
        Auteur a = new Auteur(nom, prenom, naissance);

        String titre = faker.book().title();
        String isbn = faker.code().isbn10();
        LocalDate datePublication = faker.timeAndDate().birthday(19, 500);
        Livre l = new Livre(titre, isbn, datePublication, a);


        a= this.auteurRepo.save(a);

        return a;
    }

    /**
     * renvoit un auteur sécurisé ; un auteur sans password et dont le livre n'affiche pas son auteur (evite la récursivité)
     * explicite l'usage de DTO pour masquer des informations
     * mappé sur la route /bibliotook/auteurLivre
     * @return
     */
    @GetMapping("/bibliotook/auteurLivre")
    public AuteurSecurise auteurAvecLivre(){
        Auteur a = new Auteur();
        Livre l = new Livre("encore 50 nuances de gray", "OASJ", LocalDate.now(), a);
        a.addLivre(l);
        return new AuteurSecurise(a);
    }

    /**
     * permet de récupérer la liste de tous les auteurs dont le nom match avec le paramettre d'URL "name"
     * mappé sur la route /bibliotook/auteur/name
     * @param nomRecherche - mappé avec "name"
     * @return les auteurs récupérés sont des auteurs sécurisés (pas de password, livres n'affichent pas leurs auteurs
     */
    @GetMapping( "/bibliotook/auteur/{name}")
    public List<AuteurSecurise> getAuteurByName( @PathVariable(value = "name") String nomRecherche) {
        Set<Auteur> auteurs = auteurRepo.findByNom(nomRecherche);

        List<AuteurSecurise> auteurSecurises = new ArrayList<>();
        for (Auteur a : auteurs){
            auteurSecurises.add(new AuteurSecurise(a));
        }
        return auteurSecurises;
    }

    /**
     * premier post réalisé
     * receptionne un livre sous forme de JSON et l'ajoute à la bibliothèque
     * mappé sur /bibliotook/livre
     * @param l - un livre transformé par jackson depuis le corp de la requete
     * @return la bibliotèque avec le livre ajouté
     */
    @PostMapping("/bibliotook/livre")
    public Bibliotheque ajouterLivre(@RequestBody Livre l){
        Bibliotheque b = BibliothequeFactory.getBigBibliotheque();
        b.getLivres().add(l);
        return b;
    }


    /**
     * une route qui permet d'ajouter un livre à la bibliothèque
     * l'auteur du livre est passé en argument de la route
     * si l'auteur n'existe pas dans la bibliothèque le livre n'est pas ajouté
     * la route ajouter "ajouter livre a auteur existant" de postman permet de tester cette route
     * mappée sur /bibliotook/livre/auteurNom
     * @return
     */
    @PostMapping("/bibliotook/livre/{name}")
    public ResponseEntity<Bibliotheque> ajouterLivreCorrectement(@RequestBody Livre l,  @PathVariable(value = "name") String nomAuteur) {
        Bibliotheque b = BibliothequeFactory.getBigBibliotheque();
        Set<Auteur> auteurs = b.auteurParNom(nomAuteur);

        for(Auteur a : auteurs){
            if(a.getNom().equals(nomAuteur)) {
                b.getLivres().add(l);
                l.setAuteur(a);
                return new ResponseEntity(b, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /**
     * renvoi la liste de tous les livres
     * cette méthode mobilise un dto sous forme de record
     * cette méthode mobilise les stream pour transformer les livres en livreDTO
     * @return
     */
    @GetMapping("/bibliotook/livre")
    public List<LivreAuteurSeulementNomDTO> basicLivre(){
        return livreRepository.findAll().stream().map(LivreAuteurSeulementNomDTO::fromLivre).collect(Collectors.toList());
    }

    /**
     * renvoi une nouvelle instance de bibliothèque
     * mappé sur la route /bibliotook/bibliotheque
     * @return
     */
    @GetMapping("/bibliotook/bibliotheque")
    public Bibliotheque basicBibliotheque(){
        return new Bibliotheque();
    }

    /**
     * renvoi la bibliothèque singleton existant dans le serveur.
     * mappé sur la route /bibliotook/bibliothequeBig
     * @return
     */
    @GetMapping("/bibliotook/bibliothequeBig")
    public Bibliotheque bigBibliotheque(){
        return BibliothequeFactory.getBigBibliotheque();
    }

    @GetMapping("/bibliotook/dispos")
    public List<Livre> livresDisponibles(){
        return livreRepository.findAllDispo();
    }


    @GetMapping("/emprunts")
    public List<Livre> getListEmprunts(){
        /*
        // approche par les objets (chercher les emprunteurs ; faire une liste avec leurs livres)
        Set<Usager> lesEmprunteurs = usagerRepository.findDistinctByEmpruntNotNull();
        List<Livre> emprunts = new ArrayList<>();
        for (Usager u : lesEmprunteurs){
            emprunts.add(u.getEmprunt());
        }
        return emprunts;
        //*/
        // approche par ORM
        return livreRepository.findAllEmprunt();
    }

}
