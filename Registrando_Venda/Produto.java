
/**
 *
 * @author Fábio Chacon
 */


public class Produto {
    
    private int codigo;
    private String descricao;
    private double valorVenda;
    private double valorCusto;
    private String promocao;
  
    
    
    public Produto(int codigo, String descricao, int valorVenda, double valorCusto, String promocao)
    {
        setCodigo(codigo);
        setDescricao(descricao);
        setValorVenda(valorVenda);
        setPromocao(promocao);
    }
    
    
 
   public void setCodigo(int codigo)
   {
       this.codigo = codigo;
   }
   
   public void setDescricao(String descricao)
   {
       this.descricao = descricao;
   }
   
   public void setValorVenda(int valorVenda)
   {
       this.valorVenda = valorVenda;
   }
   
   public void setValorCusto(double valorCusto)
   {
       this.valorCusto = valorCusto;
   }
   
   public void setPromocao(String promocao)
   {
       this.promocao = promocao;
   }
   
   public int getCodigo()
   {
       return codigo;
   }
   
   public String getDescricao()
   {
       return descricao;
   }
   
   public double getValorVenda()
   {
       return valorVenda;
   }
   
   public double getValorCusto()
   {
       return valorCusto;
   }
   
   public String getPromocao()
   {
       return promocao;
   }
   
}

