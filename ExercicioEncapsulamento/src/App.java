public class App {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto("Cerveja", 15);


        Cliente cliente1 = new ClienteJuridico("Ambev S", "Juridico");
        Cliente cliente2 = new ClienteFisico("Matuzalem", "Fisico");

        
        double precoFinalJuridico = produto.calcularPrecoFinal(cliente1);

        double precoFinalFisico = produto.calcularPrecoFinal(cliente2);

        System.out.println("Preço final para " + cliente1.getNome() + ": " + precoFinalJuridico);

        System.out.println("Preço final para " + cliente2.getNome() + ": " + precoFinalFisico);

    }
}
