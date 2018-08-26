import java.util.Scanner;

public class Perc {

   
    public static void main(String[] args) {
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Introduza o salario\n");
        int sal = input.nextInt();
        System.out.printf("Introduza o percentual de aumento\n");
        int per = input.nextInt();
        
        sal = sal + sal*per/100;
       
        System.out.printf("Salario com aumento: %s\n", sal);
        
        
    }
    
}
