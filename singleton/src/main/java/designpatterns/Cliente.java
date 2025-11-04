package designpatterns; // ou "designpattern" conforme o package usado

public class Cliente {

    public static void main(String[] args) {
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
