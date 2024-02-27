package exemplo1;

import java.util.List;

public class Pedido {

    private Cliente cliente;

    private List<LinhaDePedido> linhasDePedido;
    
    private Double calcularPrecoBase(Integer quantidade, Double preco) {
        return preco * quantidade;
    }

    private Double calcularDescontos(Double precoBase) {
        Double percentualDesconto = cliente.obterInformacaoDesconto();
        //5%
        //5 / 100 = 0.05
        Double percentualConvertido = percentualDesconto / 100d;
        Double valorDesconto = precoBase * percentualConvertido;
        return precoBase - valorDesconto;
    }
    
    public Double calcularPreco() {
        Double total = 0.0d;

        for (LinhaDePedido linhadePedido: linhasDePedido) {
            Integer quantidade = linhadePedido.obterQuantidade();
            Produto produto = linhadePedido.obterProduto();
            Double preco = produto.obterDetalhesDoPreco();
            Double precoBase = calcularPrecoBase(quantidade,preco);
            Double precoFinal = calcularDescontos(precoBase);
            total += precoFinal;
        }
        return total;
    }
    
}
