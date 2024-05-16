
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexaoUsuario = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/Banco",
                "postgres","fei");
        return conexaoUsuario;
    }
}
