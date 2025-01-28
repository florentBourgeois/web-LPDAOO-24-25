package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.SchroedingerCat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

@RestController
public class HelloWorldController {

    public HelloWorldController() {
        System.err.println("HELLO WORLD A DEMARRE");
    }

    @GetMapping("/")
    public String hello(){
        return "<h1>Hello</h1> <p>world</p>";
    }

    @GetMapping("/hellotruc")
    public String helloTruc(){
        return "<h1>Hello</h1> <p>truc</p>";
    }


    @GetMapping("/autrechose")
    public Color helloAutreChose(){
        return Color.BLACK;
    }

    @GetMapping("/chat")
    public SchroedingerCat getCat(){
        LocalDate naissance  = LocalDate.of(2012, 10, 29);
        return new SchroedingerCat("miaou");
    }



}
