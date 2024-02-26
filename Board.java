public class Board
{
    private char board[][];
    
    Player red;
    Player black;
    
    public Board()
    {
        board = new char[6][7];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = ' ';
            }
        }
        
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
    
    public void printBoard(){
        System.out.println(" 1 2 3 4 5 6 7 ");
        for(int y = 0; y < board.length; y++){
            System.out.println("+-+-+-+-+-+-+-+");
            for(int x = 0; x < board[y].length; x++){
                System.out.print("+" + board[y][x]);
            }
            System.out.println("+");
        }
        System.out.println("+-+-+-+-+-+-+-+");
    }
    
    /*Returns 1 if move is possible and 0 if not*/
    public int makeMove(int pos, Player player)
    {
        return 0;
    }
}
