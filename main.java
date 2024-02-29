public class main
{
    public static void main(String[] args){
        Board board = new Board();
        char w = board.checkWinner();
        int move = -1;//-1 black , 1 red
        while(w == ' '){
            move *= -1;
            board.printBoard();
            board.getMove(move);
            w = board.checkWinner();
        }
        board.printBoard();
        
        if(w == 't'){
            System.out.println("Tie!");
        }else{
            System.out.println("Winner: " + w + "!");
        }
    }
}
