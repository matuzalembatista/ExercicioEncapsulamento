public class App {
    public static void main(String[] args) {
        Produto produto = new Produto("Notebook", 3000.00);

        Cliente cliente1 = new Cliente("João", "PessoaFisica");
        Cliente cliente2 = new Cliente("Empresa X", "PessoaJuridica");

        Precificacao pricingEngine = new Precificacao();

        double precoFinalPessoaFisica = pricingEngine.calcularPrecoFinal(produto, cliente1);
        double precoFinalPessoaJuridica = pricingEngine.calcularPrecoFinal(produto, cliente2);

        System.out.println("Preço final para " + cliente1.getNome() + ": " + precoFinalPessoaFisica);
        System.out.println("Preço final para " + cliente2.getNome() + ": " + precoFinalPessoaJuridica);
    }
}
