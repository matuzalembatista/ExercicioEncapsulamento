package srp.depoisRefactoring;

public class CalculadorDeSalario {

    public double calcula(Funcionario funcionario) {
        return funcionario.getCargo().getRegraDeCalculo().calcula(funcionario);
    }
    
}
