import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		ClientBill client = new ClientBill();
		
		System.out.println("Por favor, digite as seguintes informações do cliente:");
		System.out.println("Sexo: ");
		char gender = scn.next().charAt(0);
		
		System.out.println("Quantidade de cervejas: ");
		int beerQuantity = scn.nextInt();
		
		System.out.println("Quantidade de refrigerantes: ");
		int softDrinkQuantity = scn.nextInt();
		
		System.out.println("Quantidade de espetinhos: ");
		int foodQuantity = scn.nextInt();
		
		client.set(gender, beerQuantity, softDrinkQuantity, foodQuantity);
		
		System.out.println("RELATÓRIO: ");
		client.consumedBill();
		client.couvertBill();
		client.ticketBill();
		
		client.totalBill();
				
		scn.close();
	}

}