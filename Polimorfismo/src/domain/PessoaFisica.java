package domain;

public class PessoaFisica extends Pessoa {

    private String cpf;

    @Override
    public boolean validaAbstract() {
        super.valida();

        boolean validouCpf = true;
        return validouCpf;        
    }
    
}
