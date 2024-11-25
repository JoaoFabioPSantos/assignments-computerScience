public class TicTacToe{
    
    private char playerIcon;
    private boolean turnPlayer = true;
    private char[][] gameArray = new char[3][3];
    
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
        
        System.out.println("  ");
/*  
  X |  -  |  -  
____+_____+____
  - |  O  | X  
____+_____+____
    |     |     
  - |  O  |  -  
*/   
        
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