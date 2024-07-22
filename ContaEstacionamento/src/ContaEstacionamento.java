import java.time.Duration;
import java.time.LocalDateTime;

public class ContaEstacionamento {

    private Veiculo veiculo;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    public ContaEstacionamento(LocalDateTime inicio,LocalDateTime fim,Veiculo veiculo) {
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
    }

    public Double valorConta() {
        Duration duracao = Duration.between(inicio, fim);

        long horas = duracao.toHours();
        long dias = horas / 24;
        long meses = dias / 30;

        if (veiculo instanceof Passeio) {
            if (horas < 12) {
                return horas * 2.0;
            } else if (dias < 15) {
                dias = dias + ((horas % 24 == 0) ? 0 : 1);
                return dias * 26.0;
            } else {
                meses = meses + ((dias % 30 == 0) ? 0 : 1);
                return meses * 300.0;
            }
        } else if (veiculo instanceof Carga) {
            return 0.0;
        }
        return 0.0;
    }
    
}
