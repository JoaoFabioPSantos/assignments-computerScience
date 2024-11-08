import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		LightBulb lightBulb = new LightBulb();
		
		int option;
		
		System.out.println(">>SEJA BEM VINDO AO SOFTWARE LÂMPADA<<");
		
		System.out.println("Cor da lâmpada: ");
		lightBulb.setColor(scn.nextLine());
		
		System.out.println("Marca da lâmpada: ");
		lightBulb.setBrand(scn.nextLine());
		
		System.out.println("Modelo da lâmpada: ");
		lightBulb.setModel(scn.nextLine());
		
		System.out.println("Watts da lâmpada: ");
		lightBulb.setWatss(scn.nextInt());
		
		System.out.println("Tipo da lâmpada: ");
		lightBulb.setType(scn.nextLine());
		
		System.out.println("Garantia da lâmpada: ");
        lightBulb.setGuaranteeTime(scn.nextTime());
		
		System.out.println("Preço da lâmpada: ");
		lightBulb.setPrice(scn.nextDouble());
		
		System.out.println("Status da lâmpada: ");
		lightBulb.setStatus(scn.nextLine());

		while(true){
		    System.out.println("Ligar/Desligar lâmpada? 0 – Sair / 1– Sim /2– Não) : ");
		    int option 
		    switch (option){
		        case 1:
		            lightBulb.turnOn();
		            break;
		            
		        case 2:
		            lightBulb.turnOff();
		            break;
		            
		        case 0:
		            break;
		            
		        default:
		            System.out.println("Opção inválida");
		            break;
		    }
		    
		}
		
		System.out.println("<Software encerrado");
	}
}