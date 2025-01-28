package fr.uha.serfa.lpdaoo25.BiblioTook.controller;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.SchroedingerCat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

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
        return new SchroedingerCat("miaou");
    }

}
