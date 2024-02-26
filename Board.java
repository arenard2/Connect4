public class Board
{
    private char board[][];
    
    Player red;
    Player black;
    
    public Board()
    {
        board = new char[6][7];
        red = new Player('R');
        black = new Player('B');
    }
    
    public void getMove(int player){
        if(player == 1){
            System.out.println("Red player's turn.");
            int move = red.getMove();
            while(makeMove(move, red) == 0){
                System.out.println("Move not possible.");
                move = red.getMove();
            }
        }
        else if(player == 2){
            System.out.println("Black player's turn.");
            int move = black.getMove();
            while(makeMove(move, black) == 0){
                System.out.println("Move not possible.");
                move = black.getMove();
            }
        }
        
    }
    
    /*Returns 1 if move is possible and 0 if not*/
    public int makeMove(int pos, Player player)
    {
        return 0;
    }
    
    
}
