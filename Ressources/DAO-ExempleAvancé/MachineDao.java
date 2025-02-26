package fr.uha.serfa.lpdaoo25.BiblioTook.dao.daoexempleAvanced;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uha.project.corderie.dto.ReducedMachine;
import uha.project.corderie.dto.ReducedMachineInterface;
import uha.project.corderie.entity.Machine;

import java.util.List;

@Repository
public interface MachineDao extends JpaRepository<Machine, Integer> {
    Machine findById(int id);

    // possible de faire des requetes maison et d'appeler des constructeurs sur ces requettes.
    // NOTA : le constructeur appelé transforme l'objet type en string (cf classe ReducedMachine)
    // source : https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns
    @Query("select new uha.project.corderie.dto.ReducedMachine(m.id, m.status, m.type) from Machine m where m.mopc.size = 1")
    List<ReducedMachine> findReduced();

    // possible de faire des requetes maison et d'en attendre un interface .
    // NOTA : comment faire pour "filtrer la donnée ?" Pour le moment non
    // source : https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns
    @Query("select m from Machine m where m.mopc.size = 1")
    List<ReducedMachineInterface> findReducedInterface();



    // possible de faire des requetes maison et de récupérer une liste d'objets.
    // Pas super sympa à utiliser si on veut faire du traitement la dessus.
    // Pour envoi par API c'est tout bon.
    // source : https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns
    // je n'arrive pas à le mobiliser a cause d'un problème de type
    //@Query("select m.id, m.status, m.type.type from Machine m where m.mopc.size = 1")
    //List<Objects> findObjects();


    // possible d'utiliser des paramettres dans les requetes
    @Query("select m from Machine m where m.status = :status or m.capacity >= :capacity")
    List<Machine> findBystatusAndCapacity(@Param("status") int status,
                                          @Param("capacity") int capacity);




    @Query(value = "select m.id as machine_id, c.id as creneau_id, of.id as of_id   from MACHINE as m\n" +
            "            left join creneau_machine as c on m.id = c.machine_id \n" +
            "            left join ordre_fabrication_creneau_machines as ofc on c.id = ofc.creneau_machines_id \n" +
            "            left join type on m.type_id = type.id \n" +
            "            left join ordre_fabrication as of on ofc.ordre_fabrication_id = of.id"
            ,nativeQuery = true)
    List<Truc> getMachinesForGant();

    public interface Truc{
        Integer getMachine_id();
        Integer getCreneau_id();
        Integer getOf_id();
    }

//*/
/*
    @Query("select new uha.project.corderie.dto.CreneauMachineForGanttDTO(c, of) from OrdreFabrication " +
            "left join CreneauMachine as c on of.creneauMachines.id = c.machine_id " +
            "left join ordre_fabrication_creneau_machines as ofc on c.id = ofc.creneau_machines_id " +
            //"left join type on m.type_id = type.id " //+
            "left join ordre_fabrication as of on ofc.ordre_fabrication_id = of.id;")
    List<CreneauMachineForGanttDTO> getCreneauForGant();
//*/
}
