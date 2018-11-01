import java.util.Random;
import java.util.Arrays;


public class Parameters {
    
    
    private double[][] W = null;
    private double[] w = null;
    private double[] b = null;  
    private Random rand = new Random();
    
    
  
   
   public void initParameters(double[][] W, double[] w, double[] bias)
   {
       for(int i = 0; i < w.length; i++)
       {
           w[i] = (0.01)*rand.nextDouble();
       }
       
       for(int k = 0; k < W.length; k++)
       {
          for(int j = 0; j < W.length; k++)
           {
               W[k][j] = (0.01)*rand.nextDouble();
           }
       }
       
       
       for(int i = 0; i < bias.length; i++)
           bias[i] = 0.0;
   }
   
   public double zLinearOutPut(double[] units, double[] w){
       
       double z = 0;
       
       for(int k = 0; k < units.length; k++)
       {
           z += units[k]*w[k];
       }
       
       return z;
   }
      
   public double Dsig(double z){
       
       return sigmoid(z)*(1-sigmoid(z));
   }
     
  
   
}
