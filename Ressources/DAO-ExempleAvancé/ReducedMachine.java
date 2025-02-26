package fr.uha.serfa.lpdaoo25.BiblioTook.dao.daoexempleAvanced;

import uha.project.corderie.entity.Type;

public class ReducedMachine {

    int id;
    int status;
    String type;
    //List<CreneauMachineForGanttDTO> creneauMachine;

    public ReducedMachine(){
    }

    public ReducedMachine(int id, int status, Type machineType) {
        this.id = id;
        this.status = status;
        this.type = machineType.getType();
    //    this.creneauMachine = creneauMachine;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
