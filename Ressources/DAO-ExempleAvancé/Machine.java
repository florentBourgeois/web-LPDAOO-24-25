package fr.uha.serfa.lpdaoo25.BiblioTook.dao.daoexempleAvanced;

import java.util.List;

@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int status;

    int capacity;

    @OneToOne
    Type type;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    List<Mopc> mopc;
    
    @OneToMany(mappedBy = "Machine",targetEntity = CreneauMachine.class)
    List<CreneauMachine> creneauMachine;

    public Machine(){};

    public Machine(int id, int status, int capacity, Type type) {
        this.id = id;
        this.status = status;
        this.capacity = capacity;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void associateMOPC(Mopc mopc){
        this.mopc.add(mopc);
    }

    public void dissociateMOPC(Mopc mopc){
        this.mopc.remove(mopc);
    }

    public List<Mopc> getMOPCS(){
        return this.mopc;
    }

    public List<CreneauMachine> getCreneauMachine() {
        return creneauMachine;
    }

    public boolean isReady(){
        return this.status == 0;
    }

    public void setCreneauMachine(List<CreneauMachine> creneauMachine) {
        this.creneauMachine = creneauMachine;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


}
