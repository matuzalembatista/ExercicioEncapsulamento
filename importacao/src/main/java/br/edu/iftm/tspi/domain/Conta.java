package br.edu.iftm.tspi.domain;

public class Conta {

    private String numero;

    private Double valorLimite;

    private Integer diaVencimento;

    private Cliente cliente;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(Double valorLimite) {
        this.valorLimite = valorLimite;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", valorLimite=" + valorLimite + ", diaVencimento=" + diaVencimento
                + ", cliente=" + cliente + "]";
    }

    

    
}
