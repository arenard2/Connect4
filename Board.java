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
        else if(player == -1){
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
        for(int i = 0; i < board.length; i++){
            if(i >= 0){    
                if(board[i][pos] != ' '){
                    board[i-1][pos] = player.getName();
                }
            } else if(board[i][pos] != ' ' && i == 0){
                return 0;
            }
        }
        return 1;
    }
    
    //returns ' ' if no one, 't' if tie, or name of player for winner
    public char checkWinner()
    {
        char dir1 = traverse(0, 0, 0);
        char dir2 = traverse(1, 0, 0);
        char dir3 = traverse(2, 0, 0);
        if(dir1 != ' '){
            return dir1;
        } else if(dir2 != ' '){
            return dir2;
        } else if(dir3 != ' '){
            return dir3;
        }
        return tie();
    }
    
    public char tie(){
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[y].length; x++){
                if(board[y][x] == ' '){
                    return ' ';
                }
            }
        }
        return 't';
    }
    
    //returns ' ' if no one, or name of player for winner
    public char traverse(int dir, int x, int y){
        //0 = right, 1 = down, 2 = diagonal
        if(dir == 0){
            int counter = 0;
            char player = ' ';
            for(int xi = x; xi < board[y].length; xi++){
                if(player != ' ' && player == board[y][xi]){
                    counter += 1;
                    if(counter == 4){
                        return player;
                    }
                } else if(player != board[y][xi]){
                    counter = 0;
                    player = board[y][xi];
                }
            }
        } else if(dir == 1){
            int counter = 0;
            char player = ' ';
            for(int yi = y; yi < board.length; yi++){
                if(player != ' ' && player == board[yi][x]){
                    counter += 1;
                    if(counter == 4){
                        return player;
                    }
                } else if(player != board[yi][x]){
                    counter = 0;
                    player = board[yi][x];
                }
            }
        } else if(dir == 2){
            int yi = y;
            int xi = x;
            int counter = 0;
            char player = ' ';
            while(yi < board.length && xi < board[0].length){
                if(player != ' ' && player == board[yi][xi]){
                    counter += 1;
                    if(counter == 4){
                        return player;
                    }
                } else if(player != board[yi][xi]){
                    counter = 0;
                    player = board[yi][xi];
                }
                xi += 1;
                yi += 1;
            }
        }
        
        return ' ';
    }
}
