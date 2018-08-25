import java.util.Scanner;


        
public class Grades {
    

  private final double vector[] = new double[5];
  
      public Grades()
      {
          setGrades();
          Table();
          checkGrades();
          classAverage();
      }
  
    
     
      public void setGrades()
      {
            Scanner input = new Scanner(System.in);
            double grade1, grade2;
            double average;
          
            
            for(int i = 0; i < vector.length; i++)
            {
                
                System.out.printf("Insira as notas do aluno\n");
                grade1 = input.nextDouble();
                grade2 = input.nextDouble();
             
                average = (grade1 + grade2)/2;
                System.out.printf("Media do aluno: %.2f\n", average);
                
                vector[i] = average;
                
            }
              
            
          input.close();         
                 
     }
      
      
     public void Table()
     {
     
         System.out.print("Média Aritmetica\tMensagem"
             + "\nAbaixo de 3,0\t\tReprovado\nDe 3,0 a 7,0"
             + "\t\tExame\nAcima de 7,0\t\tAprovado\n");
 
     }
     
     
     public void checkGrades()
     {
       
         int reprovado = 0, exame = 0, aprovado = 0;
         
         for(double component : vector)
         {
             component = (component > 0 ? component : 0);
             
             if(component < 3.0)
             {
                 ++reprovado;
             }
             if(component <= 7.0)
             {
                ++exame;
             }
             else
                 ++aprovado;
         }
         
         System.out.printf("Alunos Reprovados: %s\nAlunos em Exame: %s\n"
                 + "Alunos Aprovados: %s\n", reprovado, exame, aprovado);
         
       
         
    }
     
     public void classAverage()
     {
         double classAverage = 0;
         for(double i : vector)
         {
            classAverage += i; 
         }
         
        System.out.printf("Media da Classe: %.2f\n", classAverage/6);
     }
  


    
}
