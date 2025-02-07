package fr.uha.serfa.lpdaoo25.BiblioTook.utils;

import fr.uha.serfa.lpdaoo25.BiblioTook.model.Autheur;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Bibliotheque;
import fr.uha.serfa.lpdaoo25.BiblioTook.model.Livre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BibliothequeFactory {

    private static Optional<Bibliotheque> bibSingleton = Optional.empty();

    public static Bibliotheque getBigBibliotheque() {
        if(bibSingleton.isPresent()){
            return bibSingleton.get();
        }

        List<Autheur> autheurs = new ArrayList<>();
        autheurs.add(new Autheur("Fred", "Fred", LocalDate.of(1900,10,10)));
        autheurs.add(new Autheur("John", "Doe", LocalDate.of(1980,5,15)));
        autheurs.add(new Autheur("Jane", "Smith", LocalDate.of(1975,8,20)));
        autheurs.add(new Autheur("Alice", "Johnson", LocalDate.of(1990,12,5)));
        autheurs.add(new Autheur("Bob", "Brown", LocalDate.of(1965,3,30)));
        autheurs.add(new Autheur("Charlie", "Davis", LocalDate.of(1950,7,25)));
        autheurs.add(new Autheur("David", "Wilson", LocalDate.of(2000,1,10)));
        autheurs.add(new Autheur("Eve", "Taylor", LocalDate.of(1995,11,15)));
        autheurs.add(new Autheur("Frank", "Anderson", LocalDate.of(1985,4,18)));
        autheurs.add(new Autheur("Grace", "Thomas", LocalDate.of(1970,9,22)));

        List<Livre> livres = new ArrayList<>();
        livres.add(new Livre("Evasion et retrouvailles", "OAYX083", LocalDate.of(2020, 10,11), autheurs.get(0)));
        livres.add(new Livre("Aventure en mer", "BXYA123", LocalDate.of(2019, 5, 20), autheurs.get(1)));
        livres.add(new Livre("Mystère de la forêt", "CDEZ456", LocalDate.of(2018, 3, 15), autheurs.get(1)));
        livres.add(new Livre("Voyage dans l'espace", "FGHI789", LocalDate.of(2017, 7, 25), autheurs.get(1)));
        livres.add(new Livre("Secrets du désert", "JKLM012", LocalDate.of(2016, 11, 30), autheurs.get(3)));
        livres.add(new Livre("Trésor caché", "NOPQ345", LocalDate.of(2015, 2, 10), autheurs.get(4)));
        livres.add(new Livre("Légende urbaine", "RSTU678", LocalDate.of(2014, 8, 5), autheurs.get(4)));
        livres.add(new Livre("Histoire d'amour", "VWXY901", LocalDate.of(2013, 12, 18), autheurs.get(5)));
        livres.add(new Livre("Énigme du passé", "ZABC234", LocalDate.of(2012, 4, 22), autheurs.get(8)));
        livres.add(new Livre("Aventure en montagne", "DEFG567", LocalDate.of(2011, 6, 14), autheurs.get(9)));
        livres.add(new Livre("L'ombre du vent", "HIJK890", LocalDate.of(2010, 9, 10), autheurs.get(0)));
        livres.add(new Livre("Le secret des pyramides", "LMNO123", LocalDate.of(2009, 8, 15), autheurs.get(1)));
        livres.add(new Livre("La cité perdue", "PQRS456", LocalDate.of(2008, 7, 20), autheurs.get(3)));
        livres.add(new Livre("Les mystères de l'océan", "TUVW789", LocalDate.of(2007, 6, 25), autheurs.get(3)));
        livres.add(new Livre("L'île au trésor", "XYZA012", LocalDate.of(2006, 5, 30), autheurs.get(4)));
        livres.add(new Livre("Le fantôme de l'opéra", "BCDE345", LocalDate.of(2005, 4, 10), autheurs.get(5)));
        livres.add(new Livre("Le château hanté", "FGHI678", LocalDate.of(2004, 3, 15), autheurs.get(6)));
        livres.add(new Livre("Les secrets de la jungle", "JKLM901", LocalDate.of(2003, 2, 20), autheurs.get(7)));
        livres.add(new Livre("Le trésor des pirates", "NOPQ234", LocalDate.of(2002, 1, 25), autheurs.get(8)));
        livres.add(new Livre("L'énigme de la momie", "RSTU567", LocalDate.of(2001, 12, 30), autheurs.get(9)));
        livres.add(new Livre("Le mystère de la grotte", "VWXY890", LocalDate.of(2000, 11, 10), autheurs.get(0)));
        livres.add(new Livre("Les secrets de l'île", "ZABC123", LocalDate.of(1999, 10, 15), autheurs.get(1)));
        livres.add(new Livre("L'aventure en Amazonie", "DEFG456", LocalDate.of(1998, 9, 20), autheurs.get(9)));
        livres.add(new Livre("Le trésor de la montagne", "HIJK789", LocalDate.of(1997, 8, 25), autheurs.get(3)));
        livres.add(new Livre("Les mystères de l'Atlantide", "LMNO012", LocalDate.of(1996, 7, 30), autheurs.get(4)));
        livres.add(new Livre("Le fantôme du château", "PQRS345", LocalDate.of(1995, 6, 10), autheurs.get(5)));
        livres.add(new Livre("Les secrets de la forêt", "TUVW678", LocalDate.of(1994, 5, 15), autheurs.get(6)));
        livres.add(new Livre("L'énigme de la pyramide", "XYZA901", LocalDate.of(1993, 4, 20), autheurs.get(7)));
        livres.add(new Livre("Le trésor caché", "BCDE234", LocalDate.of(1992, 3, 25), autheurs.get(8)));
        livres.add(new Livre("Les mystères de l'espace", "FGHI567", LocalDate.of(1991, 2, 25), autheurs.get(9)));

        Bibliotheque b = new Bibliotheque("10 rue du livre", "Bibliothèque", livres);
        bibSingleton = Optional.of(b);
        return b;
    }



}
