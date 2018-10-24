
/**
 *
 * @author Fábio Chacon
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        
        
        Produto produto = new Produto(2334234, "Maquina de lavar", 850, 100.00, "não");
        Vendedor vendedor = new Vendedor("Marcio", "Rua xyz, nº130", 21231);
        Venda venda = new Venda();
        
        venda.setProduto(produto);
        venda.setVendedor(vendedor);
        venda.setQuantidadeItens(2);
        venda.calcularValor();
        System.out.println("Valor da comissão " + "R$" + venda.calcularComissao());
        System.out.println(venda);
        
        Produto produto2 = new Produto(44314, "Smartphone", 100, 80.00, "sim");
        Vendedor vendedor2 = new Vendedor("Quintus Fabius Maximus", "Via Apia, Roma", 34532);
        Venda venda2 = new Venda();
        
        venda2.setProduto(produto2);
        venda2.setVendedor(vendedor2);
        venda2.setQuantidadeItens(2);
        venda2.efetuarDesconto(10);
        venda2.calcularValor();
        System.out.println("Valor da comissão " + "R$" + venda2.calcularComissao());
        System.out.println(venda2);
        
        Venda venda3 = new Venda();
        
        venda3.setProduto(produto2);
        venda3.setVendedor(vendedor2);
        venda3.setQuantidadeItens(venda2.getQuantidadeItens());
        venda3.efetuarDesconto(30);
        venda3.calcularValor();
        System.out.println("Valor da comissão " + "R$" + venda3.calcularComissao());
        System.out.println(venda3);
        
    }
    
}
