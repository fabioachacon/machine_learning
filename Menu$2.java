package locadoraveiculos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.*;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;



public class Menu {
	
	private List<Cliente> cliente = new ArrayList<Cliente>();
	private ListaVeiculos listaVeiculos = new ListaVeiculos();
	private LocacaoVeiculo locacao;
    private CadastroVeiculo cadastro;
    private JFrame frame = new JFrame();
    private JRadioButton carroRadioButton, motoRadioButton;
    private ButtonGroup radioGroup;
    private JLabel label;
    private JButton button;
    
    
    public Menu() {
    	
     new CadastroVeiculo();
    	
    	
    }
    
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
			 showFrame();
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
	
	
	public void showFrame() {
		 
		 FlowLayout layout = new FlowLayout();
		 button = new JButton("OK");
		 ButtonHandler handler = new ButtonHandler();
		 
		 carroRadioButton = new JRadioButton("Carro");
		 motoRadioButton  = new JRadioButton("Moto");
		 
		 radioGroup = new ButtonGroup();
		 radioGroup.add(carroRadioButton);
		 radioGroup.add(motoRadioButton);
		 
		 carroRadioButton.addItemListener(new RadioButtonHandler());
		 motoRadioButton.addItemListener(new RadioButtonHandler());
		 
		 label = new JLabel("Selecione o tipo de Veículo");
		 
		 frame.setLayout(layout);
		 frame.add(label);
		 frame.add(carroRadioButton);
		 frame.add(motoRadioButton);
		 frame.add(button);
		 
		 button.addActionListener(handler);
		
			 
		 
		 frame.setSize(275, 100);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		  
		 
		
	}
	
	public void exibirCarros() {
		
		JFrame frame = new JFrame();
		
		JList carroLista = new JList(listaVeiculos.getCarros());
	    carroLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    carroLista.setVisibleRowCount(6);
	    
	    frame.setLayout(new FlowLayout());
	    frame.add(new JScrollPane(carroLista));
	    frame.setSize(275, 100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    
	    carroLista.addListSelectionListener(new ListSelectionListener() {
	    	
	    	public void valueChanged(ListSelectionEvent event) {
	    		
	    	cadastro.setTipoVeiculo(listaVeiculos.getCarros()[carroLista.getSelectedIndex()]);
	    		
	    	}
	    	
	    });
	    
	   
	 
	}
	
   public void exibirMotos() {
	   
	     JList motoLista  = new JList(listaVeiculos.getMotos());
		 motoLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   }
   
   private class ButtonHandler implements ActionListener{
	        
	        public void actionPerformed(ActionEvent event) {
	        	
	        	
	        }
   }
	
	
	private class RadioButtonHandler implements ItemListener {
		
		public void itemStateChanged(ItemEvent event) {
			
		
		
	      }
	
		
	}
	
}
	
	
	


