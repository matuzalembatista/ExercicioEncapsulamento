public class ClienteJuridico extends Cliente {

    public ClienteJuridico(String nome, String tipo) {
        super(nome, tipo);
    }

    @Override
    public double aplicarDesconto(double precoBase) {
        double precoDesconto = precoBase * 0.2;
        precoDesconto = precoBase - precoDesconto;
        return precoDesconto;
    }
}
