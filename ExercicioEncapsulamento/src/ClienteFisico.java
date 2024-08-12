public class ClienteFisico extends Cliente {

    public ClienteFisico(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public double aplicarDesconto(double precoBase) {
        double precoDesconto = precoBase * 0.1;
        precoDesconto = precoBase - precoDesconto;
        return precoDesconto;
    }
}
