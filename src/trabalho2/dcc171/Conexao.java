package trabalho2.dcc171;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
//USO DE PADRAO SINGLETON    

    private static Connection instancia;

    public static Connection getInstance() throws ClassNotFoundException, Exception {
        if (instancia == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            instancia = DriverManager.getConnection("jdbc:derby://localhost:1527/trab02", "usuario", "senha");
        }
        return instancia;
    }
}
        