
package designpatterns;


/*
Qual é o principal objetivo do padrão de projeto Strategy?
O principal objetivo do padrão de projeto Strategy é definir uma família de algoritmos, 
encapsular cada um deles e torná-los intercambiáveis.

Isso permite que o algoritmo varie independentemente dos clientes que o utilizam.

Ao usar o padrão Strategy, você pode alterar o comportamento de um objeto em tempo de execução,
sem a necessidade de modificar o código do objeto que o utiliza. Isso promove a flexibilidade e a reutilização 
de código, facilitando a manutenção e a extensão já que para cada adição de uma nova "estrategia" podemos apenas implementar uma nova classe sem a necessidade de apagar ou reescrever a parte principal do algorítimo: 
Exemplo prático: cálculo de frete em um sistema de pedidos implementado abaixo.
*/ 




public class Cliente {

    public static void main(String[] args) {

        Pedido p1 = new Pedido(2.5, 100.0);

        p1.setEstrategiaFrete(new FretePAC());
        p1.calcularFrete();

        p1.setEstrategiaFrete(new FreteSEDEX());
        p1.calcularFrete();

        p1.setEstrategiaFrete(new FreteTransportadora());
        p1.calcularFrete();
    }
}
