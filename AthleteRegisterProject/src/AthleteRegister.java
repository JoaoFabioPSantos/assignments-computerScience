public class AthleteRegister{
    
    private String name;
    private char gender;
    private double height;
    private double weight;
    
    public void Gets(String name, char gender, double height, double weight){
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
    
    public boolean verifyPositive(double value){
        if(value>0){
            return true;
        }else{
            System.out.println("Valor inválido! Digite um valor positivo: ");
            return false;
        }
        
    }
    
    public boolean verifyOptionGender(char value){
        if(value=='F' || value=='M'){
            return true;
        }else{
            System.out.println("Valor inválido! Favor, digitar F ou M: ");
            return false;
        }
        
    }
    
    public void Report(double averageWeight, double menPerceint, String womanHeigh){
        System.out.printf("Peso médio dos atletas: %.1f %%\n", averageWeight);
        System.out.println("Atleta mais alto: "+name);
        System.out.printf("Porcentagem de homens: %.1f %%%n", menPerceint);
        System.out.println(womanHeigh);
    }
    
    
}
