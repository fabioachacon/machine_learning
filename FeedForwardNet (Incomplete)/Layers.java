
import java.util.Random;


public class Layers {
    
    private  int[] units = null;
    private Parameters[] = null;
    private Activations[] act = null;
    
    
    public Layers(int units, String act){
        
        
        setUnits(units);
       
       
    }

    
    public  void setUnits(int units){
        
        this.units = new int[units];
       
    }
    
 public void initParameters(double[][] W, double[] w, double[] bias)
   {
       Random rand = new Random();
       
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
   
   public double[] computActivations(int dim, double[][] W, double[] input){
       
     double[] z = new double[dim];
     

          for(int k = 0; k < W.length; k++)
              for(int j = 0; j < input.length; j++)
                     z[k] += input[j]*W[k][j];
             
              
        return z;  
           
   }
   
    
}
