
package designpatterns;

public class Cliente {

    public static void main(String[] args) {

        Pedido p1 = new Pedido(2.5, 100.0);

        // Usando a estratégia PAC
        p1.setEstrategiaFrete(new FretePAC());
        p1.calcularFrete();

        // Trocando a estratégia para SEDEX
        p1.setEstrategiaFrete(new FreteSEDEX());
        p1.calcularFrete();

        // Trocando para Transportadora
        p1.setEstrategiaFrete(new FreteTransportadora());
        p1.calcularFrete();
    }
}
