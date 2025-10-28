package gohorse;

public class Cliente {

    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        pedido.aprovarPagamento();
        pedido.submeterPedido();

        pedido.enviarPedido();
        pedido.aprovarPagamento();

        pedido.cancelarPedido();
        pedido.enviarPedido();
    }

}