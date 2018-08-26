import java.util.Scanner;

public class prestacao {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        double val_prest;
        
        System.out.printf("Insira o salario bruto\n");
        int sal = input.nextInt();
        
        val_prest = sal*(30/100);
        
        System.out.print("Insira o valor da prestacao\n");
        int prest = input.nextInt();
        
        if(prest <= val_prest)
        {
            System.out.printf("Emprestimo pode ser concedido\n");
  
        }
        else
            System.out.printf("Emprestimo não pode ser concedido\n");
        
        
    }
    
}
