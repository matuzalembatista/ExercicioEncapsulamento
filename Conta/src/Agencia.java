import java.util.List;

public class Agencia {
    private String numero;
    private List<Conta> contas; 
    
    public void saque(String numeroConta,double valor) throws ContaException {
       Conta conta = getConta(numeroConta);
       if (valor > 0) {
          if (conta.getSaldo() >= valor) {
             conta.setSaldo(conta.getSaldo() - valor);
          } else {
             throw new ContaException("Conta sem saldo suficiente: "+conta.getSaldo());
          }
       } else {
             throw new ContaException("Valor inválido para saque "+valor);
       }
    }

    public void deposito(String numeroConta,double valor) throws ContaException {
       Conta conta = getConta(numeroConta);
       if (valor > 0) {
          conta.setSaldo(conta.getSaldo() + valor);
       } else {
          throw new ContaException("Valor inválido para depósito "+valor);
       }
    }

    private Conta getConta(String numeroConta) throws ContaException {
       for (Conta conta: contas) {
          if (conta.getNumeroConta().equals(numeroConta)) {
             return conta;
          }
       }
       throw new ContaException("Numero da conta "+numeroConta+" não existe");
    }

}
    