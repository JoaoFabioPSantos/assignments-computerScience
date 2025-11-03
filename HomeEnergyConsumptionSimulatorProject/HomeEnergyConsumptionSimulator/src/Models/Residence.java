package Models;

import Controllers.ElectronicApplianceController;

public class Residence {
    private static int nextId = 1;
    private int id;
    private String name;
    ElectronicApplianceController eletronicAppResidence = new ElectronicApplianceController();

    public Residence(String name) {
        this.id = nextId ++;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
