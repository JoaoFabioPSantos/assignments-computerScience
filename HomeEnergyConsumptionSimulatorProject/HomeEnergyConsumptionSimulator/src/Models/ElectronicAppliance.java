package Models;

public class ElectronicAppliance {
    private static int nextId = 1;
    private int id;
    private String name;
    private float costByHour;

    public ElectronicAppliance(String name, float costByHour){
        this.id = nextId++;
        //sum in the next electronic
        this.name = name;
        this.costByHour = costByHour;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public float getCostByHour(){
        return costByHour;
    }
}
