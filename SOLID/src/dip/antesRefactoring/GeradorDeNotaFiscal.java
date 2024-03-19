package dip.antesRefactoring;

public class GeradorDeNotaFiscal {

    private final EnviadorDeEmail email;

    private final NotaFiscalDao dao;

    public GeradorDeNotaFiscal(EnviadorDeEmail email, NotaFiscalDao dao) {
        this.email = email;
        this.dao = dao;
    }

    public NotaFiscal gera(Fatura fatura) {
        Double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor,impostoSimplesSobre0(valor));

        email.enviaEmail(nf);
        dao.persiste(nf);

        return nf;
    }

    private double impostoSimplesSobre0(Double valor) {
        return valor * 0.06;
    }
    

    
    
}
