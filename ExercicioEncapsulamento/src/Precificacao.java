public class Precificacao {

    
    public double calcularPrecoFinal(Produto produto, Cliente cliente) {
        double desconto = 0;
        double imposto = 0.1; // 10% de imposto fixo para todos os produtos
        double taxaAdicional = 50; // Taxa adicional fixa de 50 para todos os produtos

        if (cliente.getTipo().equals("PessoaFisica")) {
            desconto = 0.1; // 10% de desconto para pessoa física
        } else if (cliente.getTipo().equals("PessoaJuridica")) {
            desconto = 0.2; // 20% de desconto para pessoa jurídica
        }

        double precoComDesconto = produto.getPrecoBase() * (1 - desconto);
        double precoFinal = precoComDesconto + (precoComDesconto * imposto) + taxaAdicional;
        
        if (precoFinal < 0) {
            precoFinal = 0;
        }
        
        return precoFinal;
    }
}
