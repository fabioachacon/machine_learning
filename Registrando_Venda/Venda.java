
/**
 *
 * @author Fábio de Andrade e Edigardo Neto
 */
public class Venda {
    
   private Produto produto;
   private Vendedor vendedor;
   private double desconto;
   private int quantidadeItens;
   private double valor;
   
   public Venda()
   {
       
   }
   
   /**
    * Configura o produto no objeto Venda.
    * 
    * @param obj recebe uma cópio de um objeto tipo Produto. 
    */
   
   public void setProduto(Produto obj)
   {
       produto = obj;
   }
   
   /**
    * Configura o vendedor no objeto Venda.
    * 
    * @param tipoVendedor recebe uma cópia de um objeto tipo Vendedor. 
    */
   
   public void setVendedor(Vendedor tipoVendedor)
   {
      vendedor = tipoVendedor;
   }
    
   /**
    * Configura a quantidade de iténs no objeto Venda.
    * 
    * @param quantidade
    */
   
   public void setQuantidadeItens(int quantidade)
   {
       this.quantidadeItens = quantidade;
   }
   
   /**
    * 
    * @return retorna o produto do objeto tipo Venda. 
    */
   
   public Produto getProduto()
   {
       return produto;
   }
   
   /**
    * 
    * @return retorna uma referência a um objeto tipo Vendedor. 
    */
   
   public Vendedor getVendedor()
   {
       return vendedor;
   }
 
   /**
    * 
    * @return retorna quantidade de iténs. 
    */
   
   public int getQuantidadeItens()
   {
       return quantidadeItens;
   }
   
   /**
    * 
    * @return retorna o valor total da compra.
    */
   
   public double getValor()
   {
       valor = produto.getValorVenda() - desconto;
       return (valor > produto.getValorCusto() ? valor : 0);
   }
   
   /**
    * Esse método calcula o valor da compra.
    * 
    * @return retorna o valor.
    */
   
   public double calcularValor()
   {
       return (quantidadeItens*produto.getValorVenda());
   }
   /**
    * 
    * @param perc recebe a porcentagem do desconto.
    * 
    * @return retorna o desconto.
    */
   
   public double efetuarDesconto(int perc)
   {
    
     return desconto = produto.getValorVenda()*((double)perc/100);
   
       
   }
   
   /**
    * Esse métoda calcula a comissão do vendedor.
    * 
    * @return retorna a camissão.
    */
   public double calcularComissao()
   {
      double comissao = vendedor.getComissao()*getValor();
      
      if(produto.getPromocao().equals("sim"))
        return comissao/2;
      else
        return comissao;
   }
   
   
   public String toString()
   {
       return String.format("Nome do vendedor: %s\n"
               + "Quantidade de Itens vendidodos: %s\n"
               + "Código e descrição do produto: %s %s\n"
               + "Valor da venda: R$%.2f\n"
               + "Produto em promoção: %s\n"
               + "Valor do desconto sobre o produto: R$%.2f\n"
               + "Valor total da venda: R$%.2f\n", vendedor.getNome(), quantidadeItens,
               produto.getCodigo(), produto.getDescricao(), produto.getValorVenda(),
               produto.getPromocao(), this.desconto, getValor());
   }
   
   
   
   
}
