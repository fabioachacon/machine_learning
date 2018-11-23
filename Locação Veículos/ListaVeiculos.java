package locadoraveiculos;

import java.util.*;

public class ListaVeiculos {
	
	private String[] marcaMoto;
	private Random rand = new Random();
	private Carro[] carros = new Carro[20];
	private Moto[] motos  = new Moto[20];
	
	
	public ListaVeiculos() {
		
		setCarros();
		setMotos();
		
	}
	
	
	  /**
	   * Esse método gera aleatoriamente uma placa de veículo.
	   * @return Retorna uma String contendo a placa do veículo.
	   */
	  public String gerarPlaca() {
		  
		  String placa = "";
		  final char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWYXZ".toCharArray();
		  
		  for(int i = 0; i < 3; i++) {
			  
			placa = placa.concat(Character.toString(letras[rand.nextInt(letras.length)]));
			
		  }
		  
		 return placa.concat("-" + String.format("%04d", rand.nextInt(10000)));
	  }
	  
	  public String descricaoMoto() {
		  
		  String descricao = "";
		  
		  switch(1 + rand.nextInt(5)) {
		      
		  case 1:
			  descricao = "Esportiva";
			  break;
		  case 2:
			  descricao = "Chopper";
			  break;
		  case 3:
			  descricao = "Cruiser";
			  break;
		  case 4:
			  descricao = "Motocross";
			  break;
		  case 5:
			  descricao = "Scooter";
			  break;
	}
		  
		  return descricao;
	
	  }
	  
  public String descricaoCarro() {
		 
		  String descricao = "";
		  
		  switch(1 + rand.nextInt(3)) {
		      
		  case 1:
			  descricao = "QUATRO PORTAS/AR-CONDICIONADO/DIREÇÃO HIDRÁULICA";
			  break;
		  case 2:
			  descricao = "DUAS PORTAS/AR-CONDICIONADO/DIREÇÃO HIDRÁULICA";
			  break;
		  case 3:
			  descricao = "CABINE DUPLA/AR-CONDICIONADO";
			  break;
	}
		  
		  return descricao;
  }
  
     public String gerarMarcaCarro() {
    	 
    	 final String[] marcaCarro = {"bmw", "Volvo", "Volkswagen", "Tesla", "Ford", "Honda","Hyundai"};
    	 return marcaCarro[rand.nextInt(marcaCarro.length)].toUpperCase();
    	 
     }
     
     public String gerarMarcaMoto() {
    	 
    	 final String[] marcaMoto = {"Honda", "yamaha", "bmw", "kawasaki", "harley-davidson", "ducati"};
    	 return marcaMoto[rand.nextInt(marcaMoto.length)].toUpperCase();     
    	 
     }
	
	  public void setCarros() {
		  
	    
	    	for(int i = 0; i < carros.length; i++) {
	    		
	    		carros[i] = new Carro(gerarMarcaCarro(), gerarPlaca(), descricaoCarro(), rand.nextBoolean() ? 4 : 5);
	    	}
	    	
	    	
	    }
	 
	  public void setMotos() {
		  
		  for(int i = 0; i < motos.length; i++) {
	    		
	    		motos[i] = new Moto(gerarMarcaMoto(), gerarPlaca(), descricaoMoto(), rand.nextBoolean() ? "sim" : "não");
	    	}
		  
	}
	  
	  public Veiculo[] getCarros() {
		  
		  return carros;
	  }
	  
	  public Veiculo[] getMotos() {
		  
		  return motos;
	  }
	  
	  

}
