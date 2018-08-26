import java.util.Scanner;


public class Salary {
    
    private int  salary;
    private String name;
   
        
    public void readjustSalary()
    {
        Scanner input = new Scanner(System.in);
        int salary;
       
        System.out.printf("Forneça o nome e o salário do empregado\n");
        
        while(!("fim".equals(name = input.nextLine()))){
            
          
            salary = Integer.parseInt(input.nextLine());
            
            if(salary > 0 && salary < 500)
            {
                this.salary = salary + salary*20/100;
                System.out.printf("Nome do empregado: " + name + "\n" 
                        + "Salário reajustado: "
                        + this.salary);
                
                System.out.println();
            }
            else
            {
                System.out.printf("Empregado não tem direito ao reajuste\n");
            }
            
             
          System.out.printf("Forneça o nome e o salário do empregado\n");
          
            
        }
        
        input.close();
        
    }
    
  
  }
    



    
   
