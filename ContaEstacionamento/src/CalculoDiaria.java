import java.time.Duration;

public class CalculoDiaria {

    public Double calcularValor(Duration duracao,Veiculo veiculo) {
        long horas = duracao.toHours();
        long dias = horas / 24;
        dias = dias + ((horas % 24 == 0) ? 0 : 1);
        return dias * 26.0;
    }

}
