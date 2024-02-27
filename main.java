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
        System.out.println("Winner: " + w + "!");
    }
}
