import java.util.Scanner;
import java.util.ArrayList;

public class HospitalReport {
    
      private  double weight, height;
      private  int age, total;
      private  String gender, name;
      private int wcounter, mcounter, agecounter, pcounter;
      private ArrayList<Double> listHeigt = new ArrayList();
      private ArrayList<String> list_Wname = new ArrayList();
      private ArrayList<String> listName = new ArrayList();
      private ArrayList<Integer> listAge = new ArrayList();
      
    
    
     public void Report()
    {
     
        System.out.printf("Quantidade de pacientes: %s\n"
                + "Média de idade dos Homens: %s\n"
                + "Quant. de mulheres com altura entre 1,60cm e 1,70cm "
                + "e peso acima de 70kg: %s\n"
                + "Quant de pessoas com idade entre 18 e 25 anos: %s\n"
                + "Nome do paciente mais velho: %s\n"
                + "Nome da mulher mais baixa: %s\n"
                ,pcounter, manAge(), wcounter, agecounter, olderPac(), sWoman());
        
        
    }
     
     
    public void analysis()
    {
         Scanner input = new Scanner(System.in);
        
         System.out.printf("Forneça o nome do Paciente\n");
        
        while(!("fim".equals(name = input.nextLine())))
        {
            listName.add(name);
            
            System.out.printf("Insira a idade: \n");
            age = Integer.parseInt(input.nextLine()); 
            listAge.add(age);
            ageInterval();
        
            System.out.printf("Insira o peso\n");
            weight = Double.parseDouble(input.nextLine());
            
            System.out.printf("Insira a altura\n");
            height = Double.parseDouble(input.nextLine());
            
            System.out.printf("Insira o sexo\n");
            gender = input.nextLine();
            
            if("f".equals(gender))
            {
                list_Wname.add(name);
                listHeigt.add(height);
                womanCounter();
            }
             else
            {   
                total += age; 
                ++mcounter;
            }
            ++pcounter;
            System.out.printf("Forneça o nome do Paciente\n");
        }
    }
    
    public void womanCounter()
    { 
        if(height >= 1.60  && height <= 1.70 && weight > 70)
            ++wcounter;
    }
    
    public void ageInterval()
    {
        if(age >= 18 && age <= 25)
        {
           ++agecounter;    
        }
    }
    
    public String sWoman()
    {
       double min = listHeigt.get(0);
       
       for(int j = 1; j < listHeigt.size(); j++)
       {
         min = Math.min(min, listHeigt.get(j));
       }
       
    
     return list_Wname.get(listHeigt.indexOf(min));
     
   }
    
    public String olderPac()
    {
       
       int max = listAge.get(0);
       
       for(int i = 1; i < listAge.size(); i++)
       {
         max = Math.max(max, listAge.get(i));
       }
       
    return listName.get(listAge.indexOf(max));
    
   }
    
   
    public double manAge()
   {
      return total/mcounter;
   } 
    
    
   
}
