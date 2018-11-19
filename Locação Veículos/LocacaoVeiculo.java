package locadoraveiculos;

import java.util.*;

public class LocacaoVeiculo {
	
	private CadastroVeiculo cadastro;
	private Cliente cliente; 
	private float valorDiaria;
	private int dias;
	private double valorSeguro;
	private float desconto;
	private boolean disponibilidade;
	
	
	public void setValorDiaria() {
		
		
		
	}
	
	
	public void setValorSeguro(CadastroVeiculo tipo) {
		
	
		if(tipo.getTipoVeiculo() instanceof Carro) 
		{
			 
			 Carro carro = (Carro) tipo.getTipoVeiculo();
			 
			 valorSeguro =  (0.05 * valorDiaria * (1 + carro.getPassageiros()/20));
		}
		else
		{
			 valorSeguro =  0.09 * valorDiaria;
		}
	}
	
	public double getValorSeguro() {
		
		return valorSeguro;
	}
	
	
	
	public double valorLocacao() {
		
		return (valorDiaria * dias * getValorSeguro());
	}
   
	public double locacaoComDesconto() {
		
		return valorLocacao() - valorLocacao() * 0.12;
	}
	
	public void exibirListaVeiculos() {
		
		
		
	}

}
