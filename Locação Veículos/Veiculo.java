package locadoraveiculos;

public class Veiculo {
	
	private String marca;
	private String descricao;
	private String placa;
	
	
	public Veiculo(String descricao, String placa) {
		
		setPlaca(placa);
		setDescricao(descricao);
		
	}
	
	
	public void setDescricao(String descricao) {
		
		this.descricao = descricao;
	}
	
	
	
	public String getDescricao() {
		
		return descricao;
	}
	
	public void setPlaca(String placa) {
		
		this.placa = placa;
	}
	
	public String getPlaca() {
		
		return placa;
	}
	
	public String toString() {
		
		return String.format("Descrição: %s\n"
				           + "Placa: %s",
				           getDescricao(), getPlaca());
	}
	
	

}
