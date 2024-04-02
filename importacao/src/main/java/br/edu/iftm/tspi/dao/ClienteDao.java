package br.edu.iftm.tspi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import br.edu.iftm.tspi.domain.Cliente;

public class ClienteDao {



    public void salvarCliente(Cliente cliente) throws Exception {
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO tbCliente(cpfcli,nomcli,"+
                     "endcli,baicli,cidcli,sigest,datcad) "+
                     " values (?,?,?,?,?,?,now())";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,cliente.getCpf());
        ps.setString(2,cliente.getNome());
        ps.setString(3,cliente.getEndereco());
        ps.setString(4,cliente.getBairro());
        ps.setString(5,cliente.getCidade());
        ps.setString(6,cliente.getEstado());
        ps.execute();
    }

    public void atualizarCliente(Cliente cliente) throws Exception {
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE tbCliente set nomcli = ?,"+
                     "endcli = ?,baicli = ?,cidcli = ?, "+
                     "sigest = ? where cpfcli = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,cliente.getNome());
        ps.setString(2,cliente.getEndereco());
        ps.setString(3,cliente.getBairro());
        ps.setString(4,cliente.getCidade());
        ps.setString(5,cliente.getEstado());
        ps.setString(6,cliente.getCpf());
        ps.execute();
    }

    public void persistir(Cliente cliente) throws Exception {
        if (cliente.getInclusaoAlteracao().equals("I")) {
            salvarCliente(cliente);
        } else if (cliente.getInclusaoAlteracao().equals("A")) {
            atualizarCliente(cliente);
        } else {
            throw new Exception("desconheço essa opção de inclusão alteração:"
                                +cliente.getInclusaoAlteracao());
        }
    }

    public Integer getUltimoLote() throws Exception {
       Connection conexao = Conexao.getConnection();
       String sql = "select MAX(numlot) as maxLote "+ 
                    "from tbControleRecebimento "+
                    "where tiparq = 'CLI'";
       PreparedStatement ps = conexao.prepareStatement(sql);
       ResultSet rs = ps.executeQuery();
       if (rs.next()) {
          return rs.getInt(1);
       }
       throw new Exception("Não encontrei o último lote de cliente");
    }

}
