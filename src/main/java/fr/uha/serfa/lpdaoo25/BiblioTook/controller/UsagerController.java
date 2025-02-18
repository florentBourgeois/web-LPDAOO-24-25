package fr.uha.serfa.lpdaoo25.BiblioTook.controller;


import fr.uha.serfa.lpdaoo25.BiblioTook.dao.LivreRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.dao.UsagerRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bibliotook")
public class UsagerController {

    private UsagerRepository lesUsagerDeLaDB;
    private LivreRepository livreRepo;

    public UsagerController(UsagerRepository ur, LivreRepository lr) {
        this.lesUsagerDeLaDB = ur;
        this.livreRepo = lr;

        lesUsagerDeLaDB.save(new Usager());
        Usager u = new Usager("Fred", "Fred", LocalDate.now());
        lesUsagerDeLaDB.save(u);

        System.out.println(lesUsagerDeLaDB.findAll());

    }


    @GetMapping("/usager")
    public List<Usager> getAllUsager(){
        return lesUsagerDeLaDB.findAll();
    }

    @GetMapping("/usager/{id}")
    public ResponseEntity<Usager> getUsagerParID(@PathVariable Long id){
        Optional<Usager> peutetreUsager = lesUsagerDeLaDB.findById(id);
        if(peutetreUsager.isPresent())
            return new ResponseEntity(peutetreUsager.get(), HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
        // autre facon :
        // return lesUsagerDeLaDB.getReferenceById(id);
    }

    @PostMapping("/usager")
    public Usager addUsager(@RequestBody Usager usagerASauvegarder){
        return lesUsagerDeLaDB.save(usagerASauvegarder);
    }

    @DeleteMapping("/usager/{id}")
    public void deleteUsager(@PathVariable Long id){
         lesUsagerDeLaDB.deleteById(id);
    }

    @PatchMapping("/usager/{id}")
    public void updateUsager(@PathVariable Long id, @RequestBody Usager usagerData){
        Usager u = lesUsagerDeLaDB.getReferenceById(id);
        if(u == null)
            return;
        u.setNaissance(usagerData.getNaissance());
        u.setNom(usagerData.getNom());
        u.setPrenom(usagerData.getPrenom());
        lesUsagerDeLaDB.save(u);
    }

    @PostMapping("/usager/{idUsager}/emprunte/{idLivre}")
    public ResponseEntity emprunter(@PathVariable(name = "idUsager") Long idUsager, @PathVariable Long idLivre){

        Optional<Usager> optionalUsager = lesUsagerDeLaDB.findById(idUsager);
        if(! optionalUsager.isPresent())
            return ResponseEntity.notFound().build();

        Optional<Livre> optionalLivre = livreRepo.findById(idLivre);
        if(! optionalLivre.isPresent())
            return ResponseEntity.notFound().build();

        Usager u = optionalUsager.get();
        Livre l = optionalLivre.get();

        u.setEmprunt(l);
        lesUsagerDeLaDB.save(u);

        return ResponseEntity.ok().build();
    }



    @PostMapping("/usager/{idUsager}/rend")
    public ResponseEntity rendre(@PathVariable(name = "idUsager") Long idUsager){

        Optional<Usager> optionalUsager = lesUsagerDeLaDB.findById(idUsager);
        if(! optionalUsager.isPresent())
            return ResponseEntity.notFound().build();

        Usager u = optionalUsager.get();

        u.setEmprunt(null);
        lesUsagerDeLaDB.save(u);

        return ResponseEntity.ok().build();
    }





}
