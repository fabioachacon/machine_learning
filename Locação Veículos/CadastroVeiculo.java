package locadoraveiculos;

import java.util.*;

public class CadastroVeiculo {
	
	private ListaVeiculos lista = new ListaVeiculos();
	private Veiculo tipoVeiculo;
	private double valor;
	

	
	public void setTipoVeiculo(Veiculo tipo) {
		
		tipoVeiculo = tipo;
	}
	
	
	public Veiculo getTipoVeiculo() {
		
		return tipoVeiculo;
	}
	
	public double getValor() {
		
		return valor;
	}
	
	public void carrosCadastrados(){
		
		for(int i = 0; i < lista.getCarros().length; i++) {
			
			System.out.println(lista.getCarros()[i]);
		}
   
 }

	public void motosCadastradas(){
		
		for(int i = 0; i < lista.getMotos().length; i++) {
			
			System.out.println(lista.getMotos()[i]);
		}
	
}

  }
