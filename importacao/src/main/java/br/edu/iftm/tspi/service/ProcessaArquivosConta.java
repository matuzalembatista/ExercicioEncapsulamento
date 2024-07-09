package br.edu.iftm.tspi.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessaArquivosConta {

    private final String PATH = "importacao\\arquivos\\";
    private final String PROCESSADOS = "importacao\\processados\\";
    private final String CONTA_PREFIX = "Conta_*";

    public void processaConta() throws Exception {
        List<Path> contasAProcessar = getContasAProcessar(); 
        for (Path contaAProcessar: contasAProcessar) {
            processaArquivo(contaAProcessar);
            moveArquivoProcessado(contaAProcessar);
        }
    }

    private List<Path> getContasAProcessar() throws Exception {
        Path dir = Paths.get(PATH);

        List<Path> fileList = new ArrayList<>();
        Files.newDirectoryStream(dir, CONTA_PREFIX).forEach(fileList::add);
        Collections.sort(fileList);

        return fileList;
    }

    private void processaArquivo(Path contaAProcessar) throws Exception {
        ProcessaLinhasConta processaConta = 
            new ProcessaLinhasConta(Files.readAllLines(contaAProcessar));
            processaConta.processa();
    }

    private void moveArquivoProcessado(Path contaAProcessar) throws Exception {
        Path dir = Paths.get(PROCESSADOS+contaAProcessar.getFileName());
        Files.move(contaAProcessar,dir);
    }

}
