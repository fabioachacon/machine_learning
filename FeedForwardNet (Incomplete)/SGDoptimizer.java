import java.util.Arrays;


public class SGDoptimizer {
 
    public double Dsig(double z){
         
         Activations act = new Activations();
       
       return act.sigmoid(z)*(1-act.sigmoid(z));
   }
    
    public void gradienDescent(double[] w, double[] units, int iterations, double learning_rate){
       
            double lr = learning_rate;
            System.out.println(Arrays.toString(w));
     
        for(int i = 0; i < iterations; i++){
           
           for(int j = 0; j < w.length; j++)
           {
               w[j] = w[j] - lr*Dsig(linear.zLinearOutPut(units, w));
               
           }
           
             System.out.println(Arrays.toString(w));
       }
       
   }  
    
}
