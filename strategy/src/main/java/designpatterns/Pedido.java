package designpatterns;
/*Classe que representa um pedido, utilizando o padrão Strategy para cálculo de frete.
 Todo pedido tem uma instncia de uma estrategia de frete que pode ser alterada em tempo 
 de execução, definindo qual será o cálculo utilizada para este pedido.
 */
public class Pedido {
    private final double pesoKg;
    private final double distanciaKm;

    private FreteStrategy estrategiaFrete;

    public Pedido(double pesoKg, double distanciaKm) {
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setEstrategiaFrete(FreteStrategy estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public double calcularFrete() {
        if (estrategiaFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete foi definida!");
        }
        return estrategiaFrete.calcular(pesoKg, distanciaKm);
    }
}
