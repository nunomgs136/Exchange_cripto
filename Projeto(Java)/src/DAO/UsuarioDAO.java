
package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Usuario;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        //String sql = "select * from aluno where usuario = '" +
        //        aluno.getUsuario() + "' AND senha = '" +
        //        aluno.getSenha() + "'";
        String sql = "select * from usuario where cpf = ? and senha = ? ";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        // corrigindo o problema da injeção de sql
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
