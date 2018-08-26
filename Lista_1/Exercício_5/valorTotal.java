import java.util.Scanner;

public class valorTotal {
    
   private double litros_gas;
   private final double valorGas = 2.50;  
   private double total;
    
    
    public void display()
    {
        setcontaTotal();
        System.out.print(this);
    }
    
    
      public void setcontaTotal()
    {
        setlitrosGas();
        total = (litros_gas)*(valorGas) + 6;       
    }
    
    
    public void setlitrosGas()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Forneça a quantidade de gasolina em litros\n");
        litros_gas = input.nextDouble();
        
        input.close();
    }
    
    public String toString()
    {
        return String.format("\tConta\n\n Gasolina: %s"
                + "\n\nRefrigerantes: %s\n\n "
                + "Valor Total: %s\n", litros_gas, 2, total);
    }
    
 
  }
