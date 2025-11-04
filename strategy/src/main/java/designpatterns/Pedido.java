package designpatterns;

public class Pedido {

    private final double pesoKg;
    private final double distanciaKm;

    // Estratégia de frete injetável
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

    // Define qual estratégia de frete será usada
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
