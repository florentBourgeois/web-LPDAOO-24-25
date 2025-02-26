package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class Manga {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    private String titre;
    private int numero;
    private int nbrPages;
    @Getter
    private String type;


    public static void main(String[] args) {
        Manga m = new Manga(1L, "naruto", 1,200, "shonen");

        System.out.println(m);
        System.out.println(m.getTitre());
        System.out.println(m.getType());
        m.setTitre("Jujutsukaisen");
        System.out.println(m);

    }
}
