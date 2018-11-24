package locadoraveiculos;

public abstract class Veiculo {
	
	private String marca;
	private String descricao;
	private String placa;
	
	
	public Veiculo(String marca, String descricao, String placa) {
		
		setMarca(marca);
		setPlaca(placa);
		setDescricao(descricao);
		
	}
	
	
	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
	}
	
	
	
	public String getDescricao() {
		
		return descricao;
	}
	
	public void setMarca(String marca) {
		
		this.marca = marca;
	}
	
	public String getMarca() {
		
		return marca;
	}
	
	public void setPlaca(String placa) {
		
		this.placa = placa;
	}
	
	public String getPlaca() {
		
		return placa;
	}
	

	
	public String toString() {
		
		return String.format("Marca: %s\n"
			               + "Descrição: %s\n"
				           + "Placa: %s", getMarca(),
				           getDescricao(), getPlaca());
	}
	
	
	
	

}
