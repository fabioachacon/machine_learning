import java.util.Scanner;

public class DailyRate {
    
    private final int dailyRate = 40;
    
     public void invoice()
    {
        int days = 0;
        int bill = 0, total = 0;
        Scanner input = new Scanner(System.in);
  
        
     System.out.printf("Insira o numero de dias (Pressione -1 para sair))\n");
   
        
      while((days = input.nextInt()) != -1)
      {  
          
          bill = (days > 0 && days < 10 ? (dailyRate+15)*days:(dailyRate+8)*days);
          total += bill;
           
          System.out.printf("Valor da conta: %s\n\n", bill);
         
          System.out.printf("Insira o numero de dias\n");
         
     }
      
      
      System.out.printf("Total Arrecadado: %s\n", total);
        
    }
    
    
    
}
