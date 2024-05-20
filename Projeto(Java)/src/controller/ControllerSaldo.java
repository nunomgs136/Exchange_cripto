///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controller;
//
//import DAO.Conexao;
//import DAO.UsuarioDAO;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import model.Carteira;
//import model.Usuario;
//import view.Login;
//import view.LoginSenha;
//import view.Menu;
//import view.Saldo;
//
///**
// *
// * @author unifnsilva
// */
//public class ControllerSaldo {
//    private Login login;
//    private Menu menu;
//    private LoginSenha senha;
//    private Carteira carteira;
//    private Saldo saldo;
//    private LoginSenha loginSenha;
//    public void loginSaldo(){
//    
//        Conexao conexao = new Conexao();
//    Usuario user = new Usuario(null, senha.getTxtSenha().getText());
//        
//                try{
//            Connection conn = conexao.getConnection();
//            UsuarioDAO dao = new UsuarioDAO(conn);
//            ResultSet res = dao.consultarSaldo(user);
//            if(res.next()){
//                JOptionPane.showMessageDialog(login,"Login feito!");
//                
//                Integer id = Integer.valueOf(res.getString("id_usuario"));
//                res = dao.consultarCarteira(id);
//                String reais = res.getString("saldoreais");
//                String bitcoin = res.getString("saldobitcoin");
//                String ripple = res.getString("saldoripple");
//                String ethereum = res.getString("saldoethereum");
//                
//                Saldo saldo = new Saldo();
//                saldo.setVisible(true);
//                login.setVisible(false);
//            }else{
//                JOptionPane.showMessageDialog(login,"Login não foi efetuado!");
//            }
//                    
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(login,"Erro de conexão!");
//                    System.out.println(e);
//        }
//    }
//
//    public ControllerSaldo() {
//    }
//
//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }
//
//    public Menu getMenu() {
//        return menu;
//    }
//
//    public void setMenu(Menu menu) {
//        this.menu = menu;
//    }
//
//    public LoginSenha getSenha() {
//        return senha;
//    }
//
//    public void setSenha(LoginSenha senha) {
//        this.senha = senha;
//    }
//
//    public Carteira getCarteira() {
//        return carteira;
//    }
//
//    public void setCarteira(Carteira carteira) {
//        this.carteira = carteira;
//    }
//
//    public Saldo getSaldo() {
//        return saldo;
//    }
//
//    public void setSaldo(Saldo saldo) {
//        this.saldo = saldo;
//    }
//
//    public LoginSenha getLoginSenha() {
//        return loginSenha;
//    }
//
//    public void setLoginSenha(LoginSenha loginSenha) {
//        this.loginSenha = loginSenha;
//    }
//
//    public ControllerSaldo(Carteira carteira, Saldo saldo) {
//        this.carteira = carteira;
//        this.saldo = saldo;
//    }
//    
//}
