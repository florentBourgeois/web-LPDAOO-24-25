package fr.uha.serfa.lpdaoo25.BiblioTook.dao.daoexempleAvanced;

import uha.project.corderie.entity.Machine;
import uha.project.corderie.entity.Type;

import java.util.List;

public class MachineForGanttDTO {

    int id;
    int status;
    Type type;
    //List<CreneauMachineForGanttDTO> creneauMachine;

    public MachineForGanttDTO(){
    }

    public MachineForGanttDTO(int id, int status, Type type, List<CreneauMachineForGanttDTO> creneauMachine) {
        this.id = id;
        this.status = status;
        this.type = type;
    //    this.creneauMachine = creneauMachine;
    }

    public static MachineForGanttDTO fromMachineAndGanttCreneaux(Machine m, List<CreneauMachineForGanttDTO> creneaux){
        return new MachineForGanttDTO(m.getId(), m.getStatus(), m.getType(), creneaux);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


/*
    public List<CreneauMachineForGanttDTO> getCreneauMachine() {
        return creneauMachine;
    }

    public void setCreneauMachine(List<CreneauMachineForGanttDTO> creneauMachine) {
        this.creneauMachine = creneauMachine;
    }
*/
    @Override
    public String toString() {
        return "MachineForGanttDTO{" +
                "id=" + id +
                ", status=" + status +
                ", type=" + type +
//                ", creneauMachine=" + creneauMachine +
                '}';
    }
}
