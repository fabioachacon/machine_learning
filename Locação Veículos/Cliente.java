package locadoraveiculos;

public class Cliente {
	
	private String nome;
	private int ID;
	private String endereco;
	private int tel;
	
	public Cliente(String name, int id, String end, int tel) {
		
		setNome(name);
		setID(id);
		setEndereco(end);
		setTel(tel);
		
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	
	public void setID(int ID) {
		
		this.ID = ID;
	}
	
	public void setEndereco(String endereco) {
		
		this.endereco = endereco;
	}
	
	public void setTel(int tel) {
		
		this.tel = tel;
	}
	
	public String getNome() {
		
		return nome;
		
	}
	
	public int getID() {
		
		return ID;
	}
	
	public int getTel() {
		
		return tel;
	}
	
	public String getEndereco() {
		
		return endereco;
	}
	
	public String toString()
	{
		return String.format("Nome: %s\n"
				          + "Identidade: %s\n"
				          + "Endereço: %s\n"
				          + "Telefone: %s\n", getNome(), getID(), getEndereco(), getTel());
	}

}
