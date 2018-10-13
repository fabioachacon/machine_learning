

public class TestException {
    
    private Integer number;
    private String name;
    private Float gradient;
    
    

    public void setName(String name) throws InvalidNameException {
          
        this.name = name;
        
        if(this.name.equals("In"))
        {
            throw new InvalidNameException();
        }
      
    }
    
    
    public void setNumber(Integer number) throws InvalidNumberException{
        
         this.number = number; 
         
         if(number.equals(100))
         {
             throw new InvalidNumberException();
         }
    }
    
    public void setGradient(Float gradient) throws ExplodingGradientException{
        
        this.gradient = gradient;
        
        if(gradient.equals(55.00))
        {
            throw new ExplodingGradientException();
        }
    }
    
    public void catchExceptions(String name, float number, float gradient){
       
        try{
            setName(name);
        }catch(InvalidNameException e){
            
            System.out.println(e);
        }
        
        try{
            setNumber(number);
        }catch(InvalidNumberException e){
            
            System.out.println(e);
        }
        
        try{
            setGradient(gradient);
        }catch(ExplodinGradientException e)
        {
            System.out.println(e);
        }
        
    }
    
}
