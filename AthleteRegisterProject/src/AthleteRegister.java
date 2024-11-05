public class AthleteRegister{
    
    private String name;
    private char gender;
    private double height;
    private float weight;
    
    public void Gets(String name, char gender, double height, float weight){
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
    
    public void Report(double averageWeight, double menPerceint, String womanHeigh){
        System.out.printf("Peso médio dos atletas: %.1f %%\n", averageWeight);
        System.out.println("Atleta mais alto: "+name);
        System.out.printf("Porcentagem de homens: %.1f %%%n", menPerceint);
        System.out.println(womanHeigh);
    }
    
    
}