package br.edu.iftm.tspi;

import br.edu.iftm.tspi.service.ProcessaArquivosCliente;
import br.edu.iftm.tspi.service.ProcessaArquivosConta;

public class Main {

    public static void main(String[] args) throws Exception {
        ProcessaArquivosCliente arquivosCliente = new ProcessaArquivosCliente();
        arquivosCliente.processaCliente();

        ProcessaArquivosConta arquivosConta = new ProcessaArquivosConta();
        arquivosConta.processaConta();
    }

}