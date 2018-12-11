package com.simulador;

public class ULA {
    
	enum OP{ADD, SUB, OR, AND};
	
	private final int BITS = 8;
    private Integer[] BX = new Integer[BITS]; //registrador B.
    private Integer[] AX = new Integer[BITS]; //registrador acumulador.
    private int OverflowFlag;
    
    public int runOperation(int data1, int data2, OP op) {
    	
    	switch(op) {
            
    	case ADD:
    		return binToInt(ADD(toBinary(data1), toBinary(data2)));
    	case SUB:
    	    return binToInt(SUB(toBinary(data1), toBinary(data2)));
    	case OR:
    	  return OR(data1, data2);
        case AND:
    	return AND(data1, data2);
    		
    }
    	
      return NOP();
    }
  
    
    public int AND(int src1, int src2){ 
        
       return src1 & src2;
    }
    
   public int OR(int src1, int src2){
       
       return src1 | src2;
   }
  
   public boolean NOT(boolean src1){
       
       return !src1;
   }
   
   public int XOR(int src1, int src2){
      
       return src1 ^ src2;
   }
   
   public int NOP(){
	   return 0;
   }
   
   public void LOAD(int data) {
	   
	  Integer[] binData = toBinary(data);
	  
	  for(int i = 0; i < binData.length; i++) {
		  
	  }
   }
   
   public Integer[] SUB(Integer[] min, Integer[] subt){
	   
	   BX = min;
	   AX = twosComplement(subt);
	  
	   return ADD(BX, AX);
}
   
   public Integer[] ADD(Integer[] num1, Integer[] num2) {
	  
       Integer[] sum = new Integer[8];
	   int carry = 0;
	   
	   BX = num1;
	   AX = num2;
	   
	   for(int i = BX.length-1;  i >= 0; i--) {
		   sum[i] = XOR(AX[i], XOR(BX[i], carry));
		   carry = OR(AND(XOR(AX[i], BX[i]), carry), AND(AX[i], BX[i]));
		 }
	   
	   AX = sum; //resultado da soma é armazenado no registrador acumulador;
	   
	   return sum;
  }
 

    public Integer[] onesComplement(Integer[] num) { //Forma do complemento de 1.
	   
    	Integer[] toOnesComp = new Integer[8];
	   
	   for(int i = 0; i < num.length; i++) {
		   if(num[i].equals(0))
			   toOnesComp[i] = 1;
		   if(num[i].equals(1))
			   toOnesComp[i] = 0;
	   }
	   
	  return toOnesComp;
   }
   
   public Integer[] twosComplement(Integer[] num) {  //Forma do complemento de 2.
	   
	  
	   Integer[] comp2 = onesComplement(num);
	   
	   int carry = 0;
	   for(int i = BX.length-1;  i >= 0; i--) {
		   comp2[i] = XOR(comp2[i], XOR(1, carry));
		   carry = OR(AND(XOR(comp2[i], 1), carry), AND(comp2[i], 1));
		 }
	   
	   return comp2;
}
    
  
   public Integer[] toBinary(int number) { //Converte um número inteiro em binário.
       
	   Integer[] inBase2 = new Integer[8];
	   char[] base2Char = String.format("%08d", Integer.parseInt(Integer.toBinaryString(number))).toCharArray();
	  
	   for(int i = 0; i < base2Char.length; i++) {
		  inBase2[i] = Integer.parseInt(Character.toString(base2Char[i]));
	  }
	   
	  return inBase2;
   }
   
   
   public Integer binToInt(Integer[] num) { //Converte binário em inteiro.
	   
	   String conv = "";
	   
	   for(int index : num) 
		   conv = conv.concat(String.valueOf(index));
	   
	   return Integer.parseInt(conv, 2);
	}
  
}