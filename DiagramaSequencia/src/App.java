import java.util.Arrays;

import exemplo2.Pedido;
import exemplo2.Cliente;
import exemplo2.LinhaDePedido;
import exemplo2.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto();
        produto.setNome("Iphone 14s");
        produto.setPreco(4000d);

        Cliente cliente = new Cliente();
        cliente.setPercentualDesconto(5d);

        LinhaDePedido linhaDePedido = new LinhaDePedido();
        linhaDePedido.setProduto(produto);
        linhaDePedido.setQuantidade(3);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setLinhasDePedido(Arrays.asList(linhaDePedido));

        System.out.println(pedido.calcularPreco());
   }

}