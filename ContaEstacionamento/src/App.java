import java.time.Duration;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDateTime inicio = LocalDateTime.of(2024, 7, 1, 14, 30);
        LocalDateTime fim = LocalDateTime.of(2024, 7, 2, 10, 30);
        Veiculo v = new Passeio();
        ContaEstacionamento conta = new ContaEstacionamento(inicio,fim, v);

        Duration duracao = Duration.between(inicio, fim);
        long horas = duracao.toHours();
        long dias = horas / 24;
        if (horas < 12) {
            conta.setCalculoValor(new CalculoHoras());
        } else if (dias < 15) {
            conta.setCalculoValor(new CalculoDiaria());
        } else {
            conta.setCalculoValor(new CalculoMensalidade());
        }
        System.out.println(conta.valorConta());
    }
}
