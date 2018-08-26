import java.util.Scanner;

public class EvenOrOdd {

 
    public static void main(String[] args) {
        
         Scanner input = new Scanner(System.in);
        
        System.out.printf("Introduza um numero\n");
        int number = input.nextInt();
        
        for(int i = 1; i <= 10; i++)
        {
            if(number%2 == 0)
            {
                System.out.printf("Par\n");
            }
            else
                System.out.printf("Impar\n");
            
            
             System.out.printf("Introduza um numero\n");
             number = input.nextInt();
            
        }
    }
    
}
