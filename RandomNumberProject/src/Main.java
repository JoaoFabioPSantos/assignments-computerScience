import java.util.Scanner;
import java.util.Random;

public class Main
{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Random randomGenerator = new Random();

		int guess;
		int limit = 0;
	    int number = randomGenerator.nextInt(101);
		System.out.println("Bem vindo ao jogo da adivinhação!\n Você tem 5 tentativas para acertar o número de 0 a 100");
	    
	    while(limit<=5){
	        if(limit==5){
	            System.out.println("Infelizmente você não acertou. ");
	            return;
	        }
	        System.out.println("Você tem "+(5-limit)+" tentativas");
	        System.out.println("DIGITE UM NÚMERO INTEIRO: ");
	        guess = scn.nextInt();
	        
	        if(guess == number){
	            System.out.println("PARABÉNS VOCÊ ACERTOU, O NÚMERO ERA: "+number);
	            return;
	        }
	        else if(guess>number){
	            System.out.println("==O número "+guess+" é maior que o número aleatório==");
	        }
	        else if(guess<number){
	            System.out.println("==O número "+guess+" é menor que o número aleatório==");
	        }
	        limit++;
	    }
	    
	}
}