package gohorse;

public class Pedido {

    private int estado;

    public Pedido() {
        this.estado = 1;
        System.out.println("gohorse.Pedido criado em Rascunho.");
    }

    public void submeterPedido() {
        if (estado == 1) {
            this.estado = 2;
            System.out.println("gohorse.Pedido submetido. Aguardando Pagamento.");
        } else {
            System.out.println("Ação 'submeter' inválida neste estado.");
        }
    }

    public void aprovarPagamento() {
        if (estado == 2) {
            this.estado = 3;
            System.out.println("Pagamento Aprovado.");
        } else {
            System.out.println("Ação 'aprovar' inválida neste estado.");
        }
    }

    public void enviarPedido() {
        if (estado == 3) {
            this.estado = 4;
            System.out.println("gohorse.Pedido Enviado.");
        } else {
            System.out.println("Ação 'enviar' inválida neste estado.");
        }
    }

    public void cancelarPedido() {
        if (estado == 1 || estado == 2) {
            this.estado = 5;
            System.out.println("gohorse.Pedido Cancelado.");
        } else if (estado == 3) {
            System.out.println("Não pode cancelar, pedido já aprovado. Iniciando estorno...");
            this.estado = 5;
        } else {
            System.out.println("Ação 'cancelar' inválida neste estado.");
        }
    }
}