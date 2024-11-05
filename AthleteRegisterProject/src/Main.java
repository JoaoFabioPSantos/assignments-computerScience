import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int quantityRegister;
		
		String nameAthlete;
        char genderAthlete;
        float weightAthlete;
        double heightAthlete;
		
		float totalWeight = 0.0f;
		float averageWeight = 0.0f;
		int highestAthlete = 0;
		double highestHeight = 0.0f;
		double menQuantity = 0;
		double womanTotalHeight = 0;
		String womanHeight;
		
		System.out.println("Qual a quantidade de atletas ?");
		quantityRegister = scn.nextInt();
		//Consome um "\n oculto"
		scn.nextLine();
		
		AthleteRegister[] athletes = new AthleteRegister[quantityRegister];
		
		for(int i=0; i<quantityRegister; i++){
		    AthleteRegister athlete = new AthleteRegister();
		    
		    System.out.println("Digite os dados do atleta");
		    
		    System.out.println("Nome:");
		    nameAthlete = scn.nextLine();
		
		    System.out.println("Gênero (F/M): ");
		    while(true){
		        genderAthlete = scn.next().charAt(0);
		        
		        if(genderAthlete=='F' || genderAthlete=='M'){
		            break;   
		        }else{
		            System.out.println("Valor invalido! Favor digitar F ou M: ");
		        }
		    }

		    System.out.println("Altura: ");
		    while(true){
		        heightAthlete = scn.nextDouble();
		        
		        if(heightAthlete>0){
		            break;   
		        }else{ 
		            System.out.println("Valor invalido! Digite um valor positivo: ");
		        }
		    }
		
		    System.out.println("Peso: ");   
            while(true){
		        weightAthlete = scn.nextFloat();
		        
		        if(weightAthlete>0){
		            break;   
		        }else{ 
		            System.out.println("Valor invalido! Digite um valor positivo: ");
		        }
		    }
            
            averageWeight += weightAthlete;
            
            if(highestHeight <= heightAthlete){
                highestHeight = heightAthlete;
                highestAthlete = i;
            }
            
            if(genderAthlete == 'M'){
                menQuantity++;
                
            }else if(genderAthlete == 'F'){
                womanTotalHeight += heightAthlete;
            }
            
            
            athlete.Gets(nameAthlete, genderAthlete, heightAthlete, weightAthlete);
            athletes[i] = athlete;
		}
		
		averageWeight /= quantityRegister;
		double menPerceint = (menQuantity/quantityRegister)*100;
		
		
		if(womanTotalHeight != 0.0){
		    double averageHeighWoman = womanTotalHeight/(quantityRegister-menQuantity);
		    womanHeight = ("Altura média das mulheres: " + averageHeighWoman); 
		}else{
		    womanHeight = "Não há mulheres cadastradas";
		}
		
		System.out.println("##RELATÓRIO##");
		athletes[highestAthlete].Report(averageWeight, menPerceint, womanHeight);
		
	}
}