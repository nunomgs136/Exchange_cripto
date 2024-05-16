




package controller;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Usuario;
import view.Login;
import DAO.Conexao;
import DAO.UsuarioDAO;
import view.Menu;
public class ControllerLogin {
    private Login login;

    public ControllerLogin(Login login) {
        this.login = login;
    }
    
    public void login(){
        Conexao conexao = new Conexao();
    Usuario user = new Usuario(login.getTxtUsuario().getText(), login.getTxtSenha().getText());
                try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(user);
            if(res.next()){
                JOptionPane.showMessageDialog(login,"Login feito!");
                
                
                
                Menu menu = new Menu();
                menu.setVisible(true);
                login.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(login,"Login não foi efetuado!");
            }
                    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(login,"Erro de conexão!");
                    System.out.println(e);
        }
    }
}
