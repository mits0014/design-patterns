package designpatterns; // ou "designpattern" dependendo do seu layout de pastas

public class GerenciadorConexao {

    // Volatile para garantir visibilidade entre threads no DCL (double-checked locking)
    private static volatile GerenciadorConexao instance;

    // Exemplo simples de "conexão" representada por uma string
    private String connectionString;

    // Private constructor
    private GerenciadorConexao(String connectionString) {
        this.connectionString = connectionString;
        // Aqui poderia vir a lógica real de abrir a conexão com o BD
        System.out.println("[GerenciadorConexao] Inicializando conexão: " + this.connectionString);
    }

    /**
     * Retorna a instância singleton. Se ainda não existir, cria com connectionString.
     * Se já existir, atualiza a configuração (reconfiguração global).
     *
     * Observação: este comportamento de "reconfigurar" é opcional — foi implementado
     * para seguir o cenário descrito onde o segundo cliente sobrescreve a configuração.
     */
    public static GerenciadorConexao getInstance(String connectionString) {
        if (instance == null) {
            synchronized (GerenciadorConexao.class) {
                if (instance == null) {
                    instance = new GerenciadorConexao(connectionString);
                } else {
                    // instância criada entre as checagens — podemos opcionalmente atualizar
                    instance.setConnectionString(connectionString);
                }
            }
        } else {
            // Instância já existe — atualizar a configuração para que todos usem a nova
            instance.setConnectionString(connectionString);
        }
        return instance;
    }

    /**
     * Retorna a instância já existente sem alterar a configuração.
     * Útil quando você quer apenas usar a instância corrente.
     */
    public static GerenciadorConexao getInstance() {
        if (instance == null) {
            throw new IllegalStateException("GerenciadorConexao ainda não inicializado. Chame getInstance(connectionString) primeiro.");
        }
        return instance;
    }

    /**
     * Define (ou redefine) a connection string usada pela instância singleton.
     * Implementado como synchronized para evitar condições de corrida simples.
     */
    public synchronized void setConnectionString(String connectionString) {
        if (connectionString == null) return;
        // Log para deixar claro que houve reconfiguração global
        if (!connectionString.equals(this.connectionString)) {
            System.out.println("[GerenciadorConexao] Reconfigurando connectionString de '" 
                + this.connectionString + "' para '" + connectionString + "'.");
            this.connectionString = connectionString;
            // Aqui você poderia reiniciar/atualizar a conexão real se necessário
        }
    }

    // Método de exemplo para executar query — apenas demonstra o uso da connectionString
    public void executarQuery(String sql) {
        // Aqui normalmente viria a execução do SQL no BD; por enquanto só simula
        System.out.println("[GerenciadorConexao] Executando on (" + this.connectionString + "): " + sql);
    }

    // (Opcional) para testes: limpar a instância (não recomendado em produção, útil em testes)
    public static synchronized void resetForTests() {
        instance = null;
    }
}
