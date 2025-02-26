# elements avancés

## requetes avancées avec spring data
Pour faire des requetes à la bdd le plus simplement possible, il est possible de mobiliser les méthodes de requetes basiques existant dans le JpaRepository.

Pour faire des requetes plus conséquentes il est possible de rédiger des noms de méthodes avec les mots clefs de JPA : https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation  (un exemple se trouve dans le fichier [AuteurRepository.java](src/main/java/fr/uha/serfa/lpdaoo25/BiblioTook/repository/Auteur.java) et [UsagerRepository.java](src/main/java/fr/uha/serfa/lpdaoo25/BiblioTook/repository/Usager.java)) )

Pour faire des requetes complexes il est possible de mobiliser l'annotation @Query : https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.at-query vous trouverez des exemples dans le fichier Ressources/DAO-ExempleAvancé/MachineDao  les autres fichiers de ce dossier
présentent les interfaces / DTO / classes qui sont mobilisées dans les requetes de la DAO


## Lombok : ne pas rédiger de getter/setter/...

Vous pouvez utiliser le starter spring-boot lombok pour ne pas avoir à rédiger de code "boilerplate". 
- un exemple est disponible dans la classe [Manga.java](src/main/java/fr/uha/serfa/lpdaoo25/BiblioTook/model/Manga.java)


## Hasher un mot de passe

Pour hasher un mot de passe, il est possible d'utiliser la librairie `BCryptPasswordEncoder` de Spring Security.
Il est recommandé de mobiliser `PasswordEncoderFactories.createDelegatingPasswordEncoder()`
- la ressource suivante explicite pourquoi il est important de hasher les mots de passer et comment le faire : https://reflectoring.io/spring-security-password-handling/

Attention ! Peut importe le choix pour l'encodage. Il sera nécéssaire de télécharger le starter **spring-boot-starter-security**
Ce starter implique automatiquement beaucoup de sécurités sur les routes : 
- impossible de faire des posts sans etre connecté -> il faut donc désactiver la sécurité csrf dans un fichier de configuration de sécurité `                .csrf(csrf -> csrf.disable())`
- impossible de mobiliser des routes sans être identifié -> il faut donc spéciiffer une configuration de sécurité `auth.anyRequest().permitAll();` dans un fichier de configuration de sécurité
- une route login est automatiquement créée 
- impossible de convertir un objet "null" par jackson  -> il faut donc gérer les erreurs de conversion ou ajouter la ligne `spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false` dans le fichier application.properties

- ignorer les sécurités sur des routes : https://www.baeldung.com/security-none-filters-none-access-permitall
- comprendre comment fonctionne spring security au pas à pas : https://openclassrooms.com/fr/courses/7137776-securisez-votre-application-web-avec-spring-security

## valider des données transmises par l'utilisateur

Pour valider des données transmises par l'utilisateur, il est possible d'utiliser les annotations de validation de Spring.
il faut ajouter la dépendance **spring-boot-starter-validation**
- le lien suivant expose les différent validateurs existants :  https://beanvalidation.org/2.0/spec/#builtinconstraints
- voici un petit tutoriel pour utilsier les validateurs : https://www.baeldung.com/spring-boot-bean-validation


## Gérer l'ensemble du processus de connexion
Les cours https://www.baeldung.com/spring-security-registration  et le code associé (https://github.com/Baeldung/spring-security-registration) 
sont des ressources précieuses mais difficiles à appréhender. 
- comprendre comment fonctionne spring security au pas à pas : https://openclassrooms.com/fr/courses/7137776-securisez-votre-application-web-avec-spring-security
