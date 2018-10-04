import java.util.*;

public class Names {
    
    private String[] names = new String[10];
    private Integer[] numbers = new Integer[10];
    
    
    public void names()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Forneça os nomes\n");
        
        for(int i = 0; i < names.length; i++)
        {
            names[i] = input.nextLine();
        }
        
        System.out.println("Antes de ordenar " + Arrays.toString(names));
        sort(names);
        
    }
    
    public void numbers()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Forneça os números\n");
        
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = input.nextInt();
        }
        
        System.out.println("Antes de ordenar " + Arrays.toString(numbers));
        sort(numbers);
        
    }
    
    
    
    public void sort(Object[] a)
    {
        Arrays.sort(a);
        System.out.println("Após ordenar " + Arrays.toString(a));
    }
    
   
    
}
