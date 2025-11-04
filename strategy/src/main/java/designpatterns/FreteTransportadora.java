package designpatterns;

public class FreteTransportadora implements FreteStrategy {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double taxaBase = 50.0;
        double volume = (pesoKg / 5.0);
        double custo = taxaBase + (volume * 10.0) + (distanciaKm * 0.05);
        System.out.println("Custo Transportadora: " + custo);
        return custo;
    }
}
