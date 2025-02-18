package fr.uha.serfa.lpdaoo25.BiblioTook.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usager extends Utilisateur{

    @ElementCollection
    private List<Address> adresses = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Livre emprunt;

    public Livre getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Livre emprunt) {
        this.emprunt = emprunt;
    }

    public Usager(String nom, String prenom, LocalDate naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public Usager() {
    }



    public int getNbrLivresEmprunt() {
        if(this.hasLivreEmprunt())
            return 1;
        return 0;
    }

    public boolean hasLivreEmprunt(){
        if(this.emprunt == null)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Usager{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", naissance=" + naissance +
                '}';
    }
}
