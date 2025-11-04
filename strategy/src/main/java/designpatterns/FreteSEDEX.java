package designpatterns;

public class FreteSEDEX implements FreteStrategy {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double custo = 25.0 + (pesoKg * 3.0) + (distanciaKm * 0.20);
        System.out.println("Custo SEDEX: " + custo);
        return custo;
    }
}
