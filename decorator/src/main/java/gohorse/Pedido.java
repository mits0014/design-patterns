package gohorse;

public class Pedido {

    private final double precoBase;

    private final boolean incluirEmbalagemPresente;

    private final boolean incluirFreteExpresso;

    private final boolean incluirSeguro;

    public Pedido(double precoBase, boolean embalagemPresente, boolean freteExpresso, boolean seguro) {
        this.precoBase = precoBase;
        this.incluirEmbalagemPresente = embalagemPresente;
        this.incluirFreteExpresso = freteExpresso;
        this.incluirSeguro = seguro;
    }

    public double calcularCustoTotal() {
        double custoTotal = precoBase;

        if (incluirEmbalagemPresente) {
            custoTotal += 5.00;
        }
        if (incluirFreteExpresso) {
            custoTotal += 15.00;
        }
        if (incluirSeguro) {
            custoTotal += (precoBase * 0.02);
        }

        return custoTotal;
    }
}

