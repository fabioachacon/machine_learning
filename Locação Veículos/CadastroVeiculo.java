package locadoraveiculos;

import java.util.*;

public class CadastroVeiculo {
	
	private ListaVeiculos lista = new ListaVeiculos();
	private Veiculo tipoVeiculo;
	private final double PRECOCARRO = 150.00;
	private final double PRECOMOTO = 80.00;
	

	
	public void setTipoVeiculo(Veiculo tipo) {
		
		tipoVeiculo = tipo;
	}
	
	
	public Veiculo getTipoVeiculo() {
		
		return tipoVeiculo;
	}
	
	
	public void exibirCarrosCadastrados(){
		
		for(int i = 0; i < lista.getCarros().length; i++) {
			
			System.out.printf("(%s)\n%s\n", i+1, lista.getCarros()[i]);
		}
   
  }
	
    public void exibirMotosCadastradas(){
		
		for(int i = 0; i < lista.getMotos().length; i++) {
			
			System.out.printf("(%s)\n%s\n", i+1, lista.getMotos()[i]);
		}
     }   

	
	
	public double valorLocacao(Veiculo veiculo) {
		
		if(veiculo instanceof Carro) {
			
			return PRECOCARRO;
		}
		else
			return PRECOMOTO;
		
	}
	
	public Veiculo[] getCarrosCadastrados() {
		
		return lista.getCarros();
	}
	
	public Veiculo[] getMotosCadastradas() {
		
		return lista.getMotos();
	}

	
  }
