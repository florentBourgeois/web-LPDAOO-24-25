package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.concurrent.ThreadLocalRandom;

/**
 * une classe naive pour expliciter l'usage de Jackson lors de la conversion en json dans le controller
 * le chat est soit vivant, soit mort à l'instanciation
 */
public class SchroedingerCat {

    /**
     * l'attribut est public -> isAlive sera visible dans le json
     */
    public boolean isAlive = false;
    private String name = "pauvre chat";

    public SchroedingerCat(String name) {
        isAlive = ThreadLocalRandom.current().nextBoolean();
        this.name = name;
    }

    /**
     * la méthode débute par get -> le nom sera visible dans le json
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * la méthode débute par get, choucroute aura une valeur dans le json
     * @return
     */
    public String getChoucroute() {
        return "hello à moi";
    }

    /**
     * la méthode débute par is, true aura une valeur dans le json
     * @return
     */
    public boolean isTrue() {
        return true;
    }

    /**
     * recussite n'apparait pas dans le json car ne débute pas par is ou get
     * @return
     */
    public String recussite(){
        this.isAlive = true;
        return "il est vivant";
    }
}
