package designpatterns;

public class FretePAC implements FreteStrategy {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double custo = 10.0 + (pesoKg * 1.5) + (distanciaKm * 0.10);
        System.out.println("Custo PAC: " + custo);
        return custo;
    }
}
