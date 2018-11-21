package locadoraveiculos;

import javax.swing.*;
import java.util.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class Menu {
	
    private List<Cliente> cliente = new ArrayList<Cliente>();
    private ListaVeiculos lista = new ListaVeiculos();
    private LocacaoVeiculo locacao;
    private CadastroVeiculo cadastro;
    private JFrame frame = new JFrame();
    private JCheckBox carroCheckBox, motoCheckBox;
    
public void displayMenu()  {
		
		String message = "1-Cadastrar Cliente\n"
			         	+"2-Exibir Lista de Clientes\n"
			         	+"3-Selecionar Veículo\n"
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
			showCheckBox();
			break;
		case 4:
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", "ERRO", JOptionPane.ERROR_MESSAGE);
			
		}
	 
	}
	
	public void cadastrarCliente() {
		
		
		
		String name, end;
		int id, tel, op = 0;
		
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
	
	
	public void showCheckBox() {
		 
		 carroCheckBox = new JCheckBox("Carro");
		 JCheckBox motoCheckBox  = new JCheckBox("Moto");
		 frame.add(carroCheckBox);
		 frame.add(motoCheckBox);
		 
		
	}
	
	public void exibirCarros() {
		
	    JList carroLista = new JList(lista.getCarros());
	    carroLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
   public void exibirMotos() {
	   
	     JList motoLista  = new JList(lista.getMotos());
             motoLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }
	
	
	private class BoxHandler implements ItemListener {
		
		public void itemStateChanged(ItemEvent event) {
			
			if(event.getSource() == carroCheckBox && carroCheckBox.isSelected()) 
			   exibirCarros();
			else
				exibirMotos();
		
	}
	
		
	}
	
}
	
	
	


