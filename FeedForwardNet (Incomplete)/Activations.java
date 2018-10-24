import java.util.Random;
/**
 *
 * @author Fábio Chacon
 */
public class Activations {
    
       
       public double sigmoid(double z){
       
       return 1/(1+Math.exp(-z));
   }
   
   public double[] ReLu(double[] z){
        
          double[] h = new double[z.length];
          
           for(int i = 0; i < z.length; i++){
               
               h[i] = Math.max(0, z[i]);
           }
           
       return h;
   }
   
   
   
    
}
