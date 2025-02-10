package fr.uha.serfa.lpdaoo25.BiblioTook.controller;


import fr.uha.serfa.lpdaoo25.BiblioTook.dao.UsageRepository;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Usager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bibliotook")
public class UsagerController {

    private UsageRepository lesUsagerDeLaDB;

    public UsagerController(UsageRepository ur) {
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
