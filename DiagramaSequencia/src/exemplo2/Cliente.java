package exemplo2;

public class Cliente {

    private Double percentualDesconto;

    public Double obterValorComDesconto(Double precoBase) {
        //5%
        //5 / 100 = 0.05
        Double percentualConvertido = percentualDesconto / 100d;
        Double valorDesconto = precoBase * percentualConvertido;
        return precoBase - valorDesconto;
    }

    public Double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    
    
}
