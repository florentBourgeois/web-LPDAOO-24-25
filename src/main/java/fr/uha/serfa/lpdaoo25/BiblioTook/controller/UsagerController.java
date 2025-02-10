package fr.uha.serfa.lpdaoo25.BiblioTook.controller;


import fr.uha.serfa.lpdaoo25.BiblioTook.dao.UsagerRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bibliotook")
public class UsagerController {

    private UsagerRepository lesUsagerDeLaDB;

    public UsagerController(UsagerRepository ur) {
        this.lesUsagerDeLaDB = ur;

        lesUsagerDeLaDB.save(new Usager());
        Usager u = new Usager("Fred", "Fred", LocalDate.now(), 107);
        lesUsagerDeLaDB.save(u);

        System.out.println(lesUsagerDeLaDB.findAll());



    }


    @GetMapping("/usager")
    public List<Usager> getAllUsager(){
        return lesUsagerDeLaDB.findAll();
    }
//*/



}
