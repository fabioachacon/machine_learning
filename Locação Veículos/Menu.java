package locadoraveiculos;

import javax.swing.*;
import java.util.*;

public class Menu {
	
	private List<Cliente> cliente = new ArrayList<Cliente>();
	private LocacaoVeiculo locacao;
	private JCheckBox box;
	
public void displayMenu() {
		
		String message = "1-Cadastrar Cliente\n"
			         	+"2-Exibir Lista de Clientes\n"
			         	+"3-Exibir Lista de Veiculos\n"
			         	+"4-Sair";
		
		int op = Integer.parseInt(JOptionPane.showInputDialog(null, message, "Selecione uma Opção", JOptionPane.PLAIN_MESSAGE));
		
		switch(op){
			
		case 1:
			cadastrarCliente();
			break;
		case 2:
			exibirListaClientes();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", "ERRO", JOptionPane.ERROR_MESSAGE);
			
		}
	 
		
		
	}
	
	public void cadastrarCliente() {
		
		
		
		String name;
		int id;
		String end;
		int tel;
		int op = 0;
		String message = "Deseja cadastrar um novo cliente?";
		
		while(op==0) {
			
			
			name = JOptionPane.showInputDialog("Insira o seu nome");
			id =  Integer.parseInt(JOptionPane.showInputDialog("Insira sua Identidade"));
			end = JOptionPane.showInputDialog("Insira seu endereço");
			tel = Integer.parseInt(JOptionPane.showInputDialog("Insira seu telefone"));
			
			cliente.add(new Cliente(name, id, end, tel));
			
			op = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
		}
		
		displayMenu();
		
	}
	
	public void exibirListaClientes() {
	
		for(int index = 0; index < cliente.size(); index++) {
			
			System.out.print(cliente.get(index).toString());
		}
	}
	

}
