/**
 *
 * @author Fábio Chacon
 */
public class Vendedor {
    
    private String nome;
    private int codigo;
    private static final double COMISSAO = 0.3;
    private String endereco;
   
    
   
    
   public Vendedor()
   {
       
   }
    
    
   public Vendedor(String nome, String endereco, int codigo)
   {
       setNome(nome);
       setEndereco(endereco);
       setCodigo(codigo);
   }
  
    
   public void setNome(String nome)
   {
       this.nome = nome;
   }
   
   public void setEndereco(String endereco)
   {
       this.endereco = endereco;
   }
   
   public void setCodigo(int codigo)
   {
       this.codigo = codigo;
   }
  
   
   public String getNome()
   {
       return nome;
   }
   
   public String getEndereco()
   {
       return endereco;
   }
   
   public int getCodigo()
   {
       return codigo;
   }
   
   public double getComissao()
   {
       return COMISSAO;
   }
    
}
