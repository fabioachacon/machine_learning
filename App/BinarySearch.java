import java.util.*;

public class BinarySearch {
    
   private final int[] array = new int[10];
   Scanner input = new Scanner(System.in);
   
   public void arrayInit()
   {
       System.out.printf("Forneça dez valores\n");
      
       
       for(int i = 0; i < array.length; i++)
       {
           array[i] = input.nextInt();
       }
       
   }
   
   public void search()
   {
       System.out.printf("Forneça o itém\n");
       int key = input.nextInt();  
       
       Arrays.sort(array);
       System.out.println(Arrays.binarySearch(array, key)); /*Utiliza método estático binarySearch() 
                                                            da classe Arrays para executar a pesquisa.
                                                              */
       
   }
   

  
    
}
