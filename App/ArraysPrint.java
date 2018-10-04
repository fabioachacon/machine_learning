import java.util.Arrays;

public class ArraysPrint {
    
    private int[] array = new int[299];
    
    public ArraysPrint() //Construtor inicializa o array.
    {
        Arrays.fill(array, 45);
    }
    
    public void printArray()
    {
        printWithFor();
        printWithEnhancedFor();
        printWithWhile();
     
    }
    
    public void printWithFor() //Imprime utilizando for convencional.
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
    
    public void printWithEnhancedFor() //Imprime utilizando for aprimorado.
    {
       for(int i: array)
       {
           System.out.println(i);
       }
    }
    
    public void printWithWhile() //Imprime utilizando while.
    {
        int i = 0;
        while(++i < array.length)
        {
            System.out.println(array[i]);
        }
    }
    
}
