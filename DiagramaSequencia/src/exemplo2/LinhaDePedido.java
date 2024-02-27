package exemplo2;

public class LinhaDePedido {

    private Produto produto;

    private Integer quantidade;

    public Double calcularPreco() {
        return produto.obterPreco(quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    
    
}
