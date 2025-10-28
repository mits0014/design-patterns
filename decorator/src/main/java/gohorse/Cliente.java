package gohorse;

public class Cliente {

    public static void main(String[] args) {

        Pedido pedido = new Pedido(100.0, true, true, false);
        System.out.println("Custo gohorse.Pedido 1: " + pedido.calcularCustoTotal());


        Pedido segundoPedido = new Pedido(200.0, false, false, true);
        System.out.println("Custo gohorse.Pedido 2: " + segundoPedido.calcularCustoTotal());
    }
}