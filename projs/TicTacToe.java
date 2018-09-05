import java.util.Scanner;
import java.util.List;



public class TicTacToe {
    
    private final int[][] grade = new int[3][3];
    private final String[][] board = new String[3][3];
    
    
    public TicTacToe()
    {
        
        for(int row = 0; row < grade.length; row++)
        {
            for(int column = 0; column < grade.length; column++)
            {
                grade[row][column] = 0;
            }
        }
    }
    
    public void displyaArray()
    {
        System.out.print(grade.length);
    }
    
    
    
    public void gamePlay(){
      
        
        
        int postion[] = new int[1];
       
        
        Scanner input = new Scanner(System.in);
        int row, column;
        int player1 = 0;
        int player2 = 0;
        System.out.printf("Start\n");
        
        while(endGame())
        {
            
            System.out.printf("Move player 1\n");
            
            postion[0] = input.nextInt(); postion[1] = input.nextInt();
            player1(postion[0],postion[1]);
            
            System.out.printf("Move player 2\n");
            
            postion[0] = input.nextInt(); postion[1] = input.nextInt();
            player2(postion[0],postion[1]);
            
            
        }
        
        whoWon();
        
        
    }
    
    
   
    
    public boolean endGame()
    {
        return (isFree() || !(diagonalsFill()));
    }
    
    
    public void player1(int row, int column)
    {
         
        if(grade[row][column] == 0)
        {
            grade[row][column] = 1;
            board[row][column] = "X";
        }
        //else
           //checkFreePosition();
   
    }
    
    
     public void player2(int row, int column)
    {
         
        if(grade[row][column] == 0 || grade[row][column] != 1)
        {
            grade[row][column] = 2;
            board[row][column] = "O";
        }
       // else
           //checkFreePosition();
    
    }
    
    
    public boolean isFree()
    {
            for(int i = 0; i < grade.length; i++)
           {
            for(int j = 0; j < grade.length; j++)
            {
               if(grade[i][j] != 0)
               {
                   return true;
               }
            }
        }
           return false;
           
        
    }
    
    public boolean diagonalsFill()
    {
        
    return ((grade[0][0] + grade[1][1] + grade[2][2] + grade[3][3] != 0)
            || (grade[0][3] + grade[1][2] + grade[2][1] + grade[3][0] != 0));
    }
    
    public void lineFill()
    {
        
    }
    
    
         
 public void displayBoard(){
       
        
   int i = 0;
   System.out.printf("\t    \tBOARD\n");
   System.out.printf("\t   0  1  2\n");
   System.out.printf("\t   - - - -\n");
 
   
    for (String[] array1 : board) {
        System.out.printf("\t");
        System.out.printf(i++ + "| ");
        for (int column = 0; column < array1.length; column++) {
            System.out.printf(array1[column] + " ");
        }
        System.out.println("");
    }
        
    }
    
   public void whoWon()
   {
            for(int i = 0; i < grade.length; i++)
            {
            for(int j = 0; j < grade.length; j++)
            {
               if((grade[i][j] == 1))
               {
                   
               }
            }
        }
       
   }
   
   public void coordinates()
   {  
       
       int[][] grid = new int[3][3];
       int k = 1;
       
         for(int i = 0; i < grid.length ; i++)
         {
            for(int j = 0; j < grid.length; j++)
            {
               grid[i][j] = k++;
            }
         }
      
    
       
   }
    
    
    
    
}



