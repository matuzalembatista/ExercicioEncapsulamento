package exemplo2;

public class Produto {

    private String nome;

    private Double preco;

    public Double obterPreco(Integer quantidade) {
        return preco * quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
