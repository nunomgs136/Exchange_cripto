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
import view.Sacar;
import java.sql.ResultSet;
import model.Carteira;
/**
 *
 * @author unifnsilva
 */
public class ControllerSaque {
    private Sacar view = new Sacar();
    private Connection conn;
    private UsuarioDAO dao = new UsuarioDAO(conn);
    public ControllerSaque(Sacar view){
        this.view = view;
    }
        public void atualizar(String id) throws SQLException{
        int saque = Integer.parseInt(view.getTxtValor().getText());
        ResultSet res = dao.consultarCarteira(Integer.parseInt(id));
       
        
        Conexao conexao = new Conexao();
        try{
            if(res.next()){
               String saldo = res.getString("saldoreais");
               Carteira carteira = new Carteira(saldo, null, 
                       null, null, Integer.parseInt(id), null, null);
               int novoSaldo = Integer.valueOf(saldo) - saque;
               if(novoSaldo >= 0){
            carteira.setReais(Integer.toString(novoSaldo));
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarSaldo(Integer.parseInt(id),carteira);
             JOptionPane.showMessageDialog(view, "Saldo atual: " + carteira.getReais());
               }else{
                   JOptionPane.showMessageDialog(view, "Fundos insuficientes!");
               }

            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
        
    }
}
