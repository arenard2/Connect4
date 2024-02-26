import java.util.Scanner;
public class Player
{
    
    private char name;
    
    public Player(char _name)
    {
        name = _name;
    }
    
    public char getName(){return name;}
    
    public int getMove()
    {
        int move = -1;
        Scanner scan = new Scanner(System.in);
        while(move < 1 && move > 7){
            System.out.print("Enter Move(1-7): ");
            move = Integer.parseInt(scan.nextLine());
        }
        return move;
    }
}
