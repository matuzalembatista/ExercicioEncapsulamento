package br.edu.iftm.tspi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.iftm.tspi.dao.ClienteDao;
import br.edu.iftm.tspi.domain.Cliente;

public class ProcessaCliente {

    private String path;

    private ClienteDao clienteDao;

    public ProcessaCliente(String path) {
        this.path = path;
        clienteDao = new ClienteDao();
    }

    public void processa() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        while (br.ready()) {
            String linha = br.readLine();
            String opcao = linha.substring(0, 1);
            if (opcao.equals("2")) {
                processaDetalhe(linha);
            } else if (opcao.equals("1")) {
                processaCabecalho(linha);
            } else {
                throw new Exception("Desconheço essa opção de processar a linha: "+opcao);
            }
        }
        br.close();
    }

    private void processaCabecalho(String linha) throws Exception {
        Integer lote = Integer.parseInt(linha.substring( 1, 4));
        Integer loteBanco = clienteDao.getUltimoLote();
        Integer loteEsperado = loteBanco + 1;
        if (!lote.equals(loteEsperado)) {
            throw new Exception("Lote recebido: "+lote+ 
                                "diferente do lote esperado:"+loteEsperado);
        }
    }

    private void processaDetalhe(String linha) throws Exception {
        Cliente cliente = getCliente(linha);
        clienteDao.persistir(cliente);
    }

    private Cliente getCliente(String linha) throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setInclusaoAlteracao(linha.substring(1,2));
        cliente.setCpf(linha.substring(2,13));
        cliente.setNome(linha.substring(13,43));
        cliente.setEndereco(linha.substring(43,73));
        cliente.setBairro(linha.substring(73,103));
        cliente.setCidade(linha.substring(103,133));
        cliente.setEstado(linha.substring(133, 135));
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
        String dataCadastro = linha.substring(135, 143);
        String horaCadastro = linha.substring(143, 149);
        Date dataHoraCadastro = sdf.parse(dataCadastro+horaCadastro);
        cliente.setDataHoraCadastro(dataHoraCadastro);
        return cliente;
    }

}
