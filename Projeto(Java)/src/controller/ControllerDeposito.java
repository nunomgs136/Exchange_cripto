/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.Deposito;
import java.sql.ResultSet;
import model.Carteira;
/**
 *
 * @author unifnsilva
 */
public class ControllerDeposito  {
    private Deposito view = new Deposito();
    private Connection conn;
    private UsuarioDAO dao = new UsuarioDAO(conn);
    public ControllerDeposito(Deposito view){
        
        this.view = view;
    }
    public void atualizar(String id) throws SQLException{
        int deposito = Integer.parseInt(view.getTxtDeposito().getText());
        ResultSet res = dao.consultarCarteira(Integer.parseInt(id));
       
        
        Conexao conexao = new Conexao();
        try{
            if(res.next()){
               String saldo = res.getString("saldoreais");
               Carteira carteira = new Carteira(saldo, null, 
                       null, null, Integer.parseInt(id), null, null);
            carteira.setReais(Integer.toString(Integer.valueOf(saldo) + deposito));
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarSaldo(Integer.parseInt(id),carteira);
             JOptionPane.showMessageDialog(view, "Saldo atual: " + carteira.getReais());
            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
        
    }
    
}
