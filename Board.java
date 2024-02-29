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
            if(i+1 != board.length){
                if(board[i][pos] != ' ' && i == 0){
                    return 0;
                } else if(board[i+1][pos]!= ' '){
                    board[i][pos] = player.getName();
                    return 1;
                } else if(i+1 == board.length-1 && board[i+1][pos] == ' '){
                    board[i+1][pos] = player.getName();
                    return 1;
                }
            }
        }
        return 1;
    }
    
    //returns ' ' if no one, 't' if tie, or name of player for winner
    public char checkWinner()
    {
        char dir1 = ' ';
        char dir2 = ' ';
        char dir3 = traverse(2, 0, 0);
        if(dir3 != ' '){
            return dir3;
        }
        
        dir3 = traverse(3, 0, 0);
        if(dir3 != ' '){
            return dir3;
        }
        
        for(int y = 0; y < board.length; y++){
            dir1 = traverse(0, 0, y);
            for(int x = 0; x < board.length; x++){
                dir2 = traverse(1, x, y);
                
                if(dir1 != ' '){
                    return dir1;
                } else if(dir2 != ' '){
                    return dir2;
                }
            }
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
                    counter = 1;
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
                    counter = 1;
                    player = board[yi][x];
                }
            }
        } else if(dir == 2){
            for(y = board.length; y >= 3; y--){
                for(x = 0; x <= board[y].length - 4; x++){
                    if(board[y][x] == board[y-1][x+1] &&
                       board[y][x] == board[y-2][x+2] &&
                       board[y][x] == board[y-3][x+3]){
                        return board[y][x];
                    }
                }
            }
        } else if(dir == 3){
            for(y = 0; y <= board.length-4; y++){
                for(x = 0; x < board[y].length - 4; x++){
                    if(board[y][x] == board[y+1][x+1] &&
                       board[y][x] == board[y+2][x+2] &&
                       board[y][x] == board[y+3][x+3]){
                        return board[y][x];
                    }
                }
            }
        }
        
        return ' ';
    }
}
