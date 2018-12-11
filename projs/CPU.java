package com.simulador;

import java.util.*;
import java.util.Iterator;
import com.simulador.ULA.OP;

public class CPU {
	
	private Integer[] AX = new Integer[8];
	private Integer[] BX = new Integer[8];
	private Integer[] CX = new Integer[8];
	private Integer[] DX = new Integer[8];
	private Integer[] EX = new Integer[8];
	private Integer[] PX = new Integer[8];
	
	private Stack<ULA> stack  = new Stack<ULA>();
	private Iterator<ULA.OP> iterator = Arrays.asList(OP.values()).iterator();
	private Iterator<ULA> stackIterator = stack.iterator();
	
	public void run() {
		
		ULA operation = new ULA();
	   
	    for(int i = 0; i < OP.values().length; i++) {
	    	
	            stack.push(operation);
	   }

	}
	
	public void runOP() {
		
		 run();
		
		 while(stackIterator.hasNext()) {
			
		 System.out.println(stack.pop().runOperation(1, 1, iterator.next()));
			 
       }
  }
}
