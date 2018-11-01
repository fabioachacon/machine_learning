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
    
   public double tanh(double z){
       
       return 2*sigmoid(2*z) - 1;
       
   }
    
   public double[] softmax(double[] z){
       
       double[] h = new double[z.length];
       double norm = 0;
       
       for(int j = 0; j < z.length; j++)
       {
           norm += Math.exp(z[j]);
       }
       
       for(int i = 0; i < z.length; i++)
       {
           h[i] = Math.exp(z[i])/norm;
       }
       
       return h;
       
   }
   
   
   
    
}
