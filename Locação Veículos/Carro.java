package locadoraveiculos;

public class Carro extends Veiculo {

	private int numPassageiros;
	
	
 public Carro(String marca, String placa, String descricao, int num) {
	 
	 super(marca, descricao, placa);
	 
	 setPassageiros(num);
	 
}
	
public void setPassageiros(int num) {
		
		numPassageiros = num;
	}
	
public int getPassageiros() {
	
	return numPassageiros;
}
	
	public String toString() {
		
		return String.format("%s\nNúmero de Passageiros: %s\n", super.toString(), getPassageiros());
	}
}
