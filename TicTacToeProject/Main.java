// Inputs: Digitar a linha e a coluna 

//Lógica : count de 3 em linha ou coluna rolando em um for a cada inserção de valor; 

// Outputs: Vez do jogador, Jogada válida ou  inválida, e o jogo por sí.


import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int linha, coluna;
		int turn = 0;
		
		System.out.println("Seja bem vindo ao Jogo da Velha!\n");
		TicTacToe game = new TicTacToe();
		
		while(turn!=9){
		    turn++;
		    game.turnSide();
		    game.showGame();
		    
		    
		     while(true){
                System.out.println("Digite a Linha: ");
                linha = scn.nextInt();
		    
		        System.out.println("Digite a Coluna: ");
		        coluna = scn.nextInt();
		        
		        if(game.fillPlace(linha, coluna))break;
		    }
		    
		    if(game.verifyWinner())break;
		}
		
		
		scn.close();
	}
}