package locadoraveiculos;

public class Carro extends Veiculo {

	private int n_passageiros;
	
	
 public Carro(String placa, String descricao, int num) {
	 
	 super(descricao, placa);
	 
	 setPassageiros(num);
	 
}
	
public void setPassageiros(int num) {
		
		n_passageiros = num;
	}
	
public int getPassageiros() {
	
	return n_passageiros;
}
	
	public String toString() {
		
		return String.format("%s\nNúmero de Passageiros: %s\n", super.toString(), getPassageiros());
	}
}
