package designpatterns; // ou "designpattern" conforme o package usado

public class Cliente {

    public static void main(String[] args) {

        // qual é o pricipal objetivo do singleton?
        // garantir uma que apenas uma instância de uma classe seja criada ou seja, neste codigo temos a classe
        //gerenciador de conexão.
        // Que tem a sua própria instância gerenciada de forma centralizada.
        // Assim, qualquer parte do sistema que precise usar o gerenciador de conexão, pode solicitar a instância única
        // através do método getInstance().
        // Isso evita a criação de múltiplas instâncias do gerenciador de conexão.
        // O que passamos para ele é a URL de conexão com o banco de dados.
        // A primeira vez que chamamos getInstance(...), a instância é criada com a URL fornecida.
        // Nas chamadas subsequentes, a mesma instância é retornada, mas com a possibilidade de reconfiguração
        // da URL de conexão.
        // ----------------------------------------------------------------
        System.out.println("cliente 1...");
        GerenciadorConexao db1 = GerenciadorConexao.getInstance("jdbc:mysql://servidor1/db");
        db1.executarQuery("SELECT * FROM usuarios");


        // ----------------------------------------------------------------
        System.out.println("cliente 2, em outra parte do sistema...");
        System.out.println("Criando (ou solicitando) a instância com nova configuração...");
        // Aqui chamamos getInstance(...) com uma nova URL — o singleton será reconfigurado
        GerenciadorConexao db2 = GerenciadorConexao.getInstance("jdbc:postgres://servidor2/db");
        db2.executarQuery("SELECT * FROM produtos");


        // ----------------------------------------------------------------
        System.out.println("gohorse.Cliente 1 tentando usar a conexão novamente...");
        System.out.println("Vai acabar usando a configuração atual (do db2)...");
        db1.executarQuery("SELECT * FROM pedidos");
    }
}
