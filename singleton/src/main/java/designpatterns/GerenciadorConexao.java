package designpatterns;

public class GerenciadorConexao {

    private static volatile GerenciadorConexao instance;

    /*
     * Usamos 'volatile' para garantir que a instância seja corretamente
     * publicada entre threads. Isso evita problemas de visibilidade em ambientes
     * multithreaded.
     * 
     * esta classe é a implementação do padrão singleton. Ela garante que apenas uma
     * instância de GerenciadorConexao seja criada durante o tempo de vida do
     * aplicativo.
     * 
     * Com isso garantimos que nosso codigo utilize sempre a mesma conexão com o banco
     * de dados, evitando múltiplas conexões desnecessárias poupando recursos em produção.
     * 
     * a mesma logica pode ser aplicada para outros recursos compartilhados, como gerenciadores de logging,
     * pools de threads, etc.
     * 
     */

    private String connectionString;

    private GerenciadorConexao(String connectionString) {
        this.connectionString = connectionString;
        System.out.println("[GerenciadorConexao] Inicializando conexão: " + this.connectionString);
    }
    public static GerenciadorConexao getInstance(String connectionString) {
        if (instance == null) {
            synchronized (GerenciadorConexao.class) {
                if (instance == null) {
                    instance = new GerenciadorConexao(connectionString);
                } else {
                    instance.setConnectionString(connectionString);
                }
            }
        } else {
            instance.setConnectionString(connectionString);
        }
        return instance;
    }

    public static GerenciadorConexao getInstance() {
        if (instance == null) {
            throw new IllegalStateException("GerenciadorConexao ainda não inicializado. Chame getInstance(connectionString) primeiro.");
        }
        return instance;
    }

    public synchronized void setConnectionString(String connectionString) {
        if (connectionString == null) return;
        if (!connectionString.equals(this.connectionString)) {
            System.out.println("[GerenciadorConexao] Reconfigurando connectionString de '" 
                + this.connectionString + "' para '" + connectionString + "'.");
            this.connectionString = connectionString;
        }
    }

    public void executarQuery(String sql) {
        System.out.println("[GerenciadorConexao] Executando on (" + this.connectionString + "): " + sql);
    }

    public static synchronized void resetForTests() {
        instance = null;
    }
}
