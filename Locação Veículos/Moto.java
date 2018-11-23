package locadoraveiculos;

public class Moto extends Veiculo {
	
	private String partidaEletrica;

public Moto (String marca, String placa, String descricao, String partida) {
	
	super(marca, descricao, placa);
	
	setPartida(partida);
	
}

public void setPartida(String partida) {
	
    partidaEletrica = partida;
 }

public String getPartida() {
	
	return partidaEletrica;
}


public String toString() {
	
	return String.format("%s\nPartida Elétrica: %s\n", super.toString(), getPartida());
}

}
