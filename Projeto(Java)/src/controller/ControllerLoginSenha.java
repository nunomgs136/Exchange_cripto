/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Usuario;
import view.Login;
import view.LoginSenha;
import view.Menu;
import view.Saldo;
import view.Comprar;
import view.Venda;
/**
 *
 * @author unifnsilva
 */
public class ControllerLoginSenha {
    private Login login;
    private Comprar compra;
    private Menu menu;
    private LoginSenha senha;
    private Carteira carteira;
    private Saldo saldo;
    private LoginSenha loginSenha;
    private int contadorSaldo;
    private int contadorCompra;
    private int contadorVenda;
    public ControllerLoginSenha(Saldo saldo, Carteira carteira) {
        this.saldo = saldo;
        
        this.carteira = carteira;
    }
    public ControllerLoginSenha(LoginSenha senha) {
        this.senha = senha;
    }
    
    
    
    public int loginSenhaApenas(int contadorS, int contadorC, int contadorV){
            Conexao conexao = new Conexao();
    Usuario user = new Usuario(null, senha.getTxtSenha().getText());
        
                try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);

            ResultSet res = dao.consultarSaldo(user);
            if(res.next()){
                JOptionPane.showMessageDialog(login,"Senha aceita!");
                
                Integer id = Integer.valueOf(res.getString("id_usuario"));
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
            if(contadorC == 1){
                    Comprar c = new Comprar();
                    c.setVisible(true);
                    return 1;
                }
            if(contadorV == 1){
                Venda v = new Venda();
                v.setVisible(true);
                return 1;
            }

                if(contadorS == 1){
                res = dao.consultarCarteira(id);
                if(res.next()){
                String reais = res.getString("saldoreais");
                String bitcoin = res.getString("saldobitcoin");
                String ripple = res.getString("saldoripple");
                String ethereum = res.getString("saldoethereum");
                
                Saldo saldo = new Saldo(new Carteira(reais, bitcoin, ripple, ethereum, id, nome, cpf));
                saldo.setVisible(true);
                return 1;
                }

                
                }


            }

            else{
                JOptionPane.showMessageDialog(login,"Senha incorreta!");
            }
                    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(login,"Erro de conexão!");
                    System.out.println(e);
        }
       return 0;
    }
}
