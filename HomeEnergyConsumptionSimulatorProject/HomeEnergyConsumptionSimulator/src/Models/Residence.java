package Models;

import Controllers.ElectronicApplianceController;

import java.util.Scanner;

public class Residence {
    private static int nextId = 1;
    private int id;
    private String name;
    private ElectronicApplianceController eletronicAppResidence = new ElectronicApplianceController();

    public Residence(String name, boolean haveEletronics, Scanner scan) {
        this.id = nextId ++;
        this.name = name;

        if(haveEletronics){
            eletronicAppResidence.register(scan);
        }
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ElectronicApplianceController getElectronicApplianceController(){
        return eletronicAppResidence;
    }

}
