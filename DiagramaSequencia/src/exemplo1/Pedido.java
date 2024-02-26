package exemplo1;

import java.util.List;

public class Pedido {

    private Cliente cliente;

    private List<LinhaDePedido> linhasDePedido;
    
    private Double calcularPrecoBase(Integer quantidade, Double preco) {
        return preco * quantidade;
    }
    
    public Double calcularPreco() {
        Double total = 0.0d;

        for (LinhaDePedido linhadePedido: linhasDePedido) {
            Integer quantidade = linhadePedido.obterQuantidade();
            Produto produto = linhadePedido.obterProduto();
            Double preco = produto.obterDetalhesDoPreco();
            Double precoBase = calcularPrecoBase(quantidade,preco);
        }


    }

}
