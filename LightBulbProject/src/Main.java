import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		LightBulb lightBulb = new LightBulb();
		int option = 1;

		System.out.println(">>SEJA BEM VINDO AO SOFTWARE LÂMPADA<<");
		
		System.out.println("Cor da lâmpada: ");
		lightBulb.setColor(scn.nextLine());
		
		System.out.println("Marca da lâmpada: ");
		lightBulb.setBrand(scn.nextLine());
		
		System.out.println("Modelo da lâmpada: ");
		lightBulb.setModel(scn.nextLine());
		
		System.out.println("Watts da lâmpada: ");
		lightBulb.setWatss(scn.nextInt());
		scn.nextLine();
		
		System.out.println("Tipo da lâmpada: ");
		lightBulb.setType(scn.nextLine());
		
		System.out.println("Garantia da lâmpada (em meses): ");
        	lightBulb.setGuaranteeTime(scn.nextInt());
        	scn.nextLine();
		
		System.out.println("Preço da lâmpada: ");
		lightBulb.setPrice(scn.nextDouble());
		scn.nextLine();
		
		System.out.println("Status da lâmpada: ");
		lightBulb.setStatus(scn.nextLine());

		while(option!=0){
		    System.out.println("Ligar/Desligar lâmpada? 0– Sair / 1– Sim /2– Não) : ");
		    option = scn.nextInt();
		    switch (option){
		        case 1:
		            lightBulb.switchMode();
		            break;
		            
		        case 2:
		            System.out.println(lightBulb.getStatus());
		            break;
		        
		        case 0:
		            System.out.println("<Software encerrado>");
		            break;
		            
		        default:
		            System.out.println("Opção inválida");
		            break;
		    }
		    
		}
	}
}
