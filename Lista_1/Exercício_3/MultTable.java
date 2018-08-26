import java.util.Scanner;

public class MultTable {
    
    public void Table()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Que tabuada deseja ver?\n");
        int number = input.nextInt();
        
        for(int i = 1; i <= 9; i++)
        {
            System.out.printf("%s" + "x" + "%s " + "= " + " %s\n", i, number, i*number);
        }
        
    }
    
}
