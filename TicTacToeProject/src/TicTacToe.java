public class TicTacToe{
    
    private char playerIcon;
    private boolean turnPlayer = true;
    private char[][] gameArray = {{'*','*','*'},{'*','*','*'},{'*','*','*'},};
    
    public void turnSide(){
        if(turnPlayer){
            playerIcon = 'X';
            turnPlayer = false;
            System.out.println("Vez do jogador: "+playerIcon);
            
        }else if(!turnPlayer){
            playerIcon = 'O';
            turnPlayer = true;
            System.out.println("Vez do jogador: "+playerIcon);
        }
    }
    
    
    public void showGame(){
       System.out.println("\n  0   1   2\n"
		                   +"0 "+gameArray[0][0]+" | "+gameArray[0][1]+" | "+gameArray[0][2]+ "\n"
		                   +" ---+---+---\n"
		                   +"1 "+gameArray[1][0]+" | "+gameArray[1][1]+" | "+gameArray[1][2]+ "\n"
		                   +" ---+---+---\n"
		                   +"2 "+gameArray[2][0]+" | "+gameArray[2][1]+" | "+gameArray[2][2]);
        
    }
    
    public boolean fillPlace(int linha, int coluna){ 
        if(gameArray[linha][coluna] == 'X' || gameArray[linha][coluna] =='O'){
         System.out.println("Posição inválida!");
         return false;
        }
        
        gameArray[linha][coluna] = playerIcon;
        return true;
    }
    
    
    public boolean verifyWinner(){
        if(true){
           System.out.println("Passou\n"+playerIcon);
        }
        return false;
    }
    
    
    public boolean winner(){
        System.out.println("O Jogador "+playerIcon+" venceu! ");
        return true;
    }
    
}
