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
import view.Comprar;
/**
 *
 * @author unifnsilva
 */
public class ControllerCompra {
    private Connection conn;
    private UsuarioDAO dao = new UsuarioDAO(conn);
    public ControllerCompra(Comprar view){
        this.view = view;
        
    }
    private Comprar view = new Comprar();
        public void atualizar(String id, int CB, int CR, int CE) throws SQLException{
        int saque = Integer.parseInt(view.getTxtBitcoin().getText());
        ResultSet res = dao.consultarCarteira(Integer.parseInt(id));
       
        
        Conexao conexao = new Conexao();
        try{
            if(res.next()){
               String saldo = res.getString("saldoreais");
               String saldoBit = res.getString("saldobitcoin");
               String saldoRipple = res.getString("saldoripple");
               String saldoEthereum = res.getString("saldoethereum");
               Carteira carteira = new Carteira(saldo, saldoBit, 
                       saldoRipple, saldoEthereum, Integer.parseInt(id), null, null);
               res = dao.consultarCotacao();
               if(res.next()){
                   String cotabit = res.getString("cotareais");
                   String cotaripple = res.getString("cotaripple");
                   String cotaethereum = res.getString("cotaethereum");
                int novoSaldoReais = Integer.valueOf(saldo) - (saque*Integer.valueOf(cotabit));
                int novoSaldoBit = Integer.valueOf(saldoBit) + saque;
               if(novoSaldoReais >= 0){
            carteira.setReais(Integer.toString(novoSaldoReais));
            carteira.setBit(Integer.toString(novoSaldoBit));
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarSaldo(Integer.parseInt(id),carteira);
             JOptionPane.showMessageDialog(view, "Saldo atual: " + carteira.getReais());
               }else{
                   JOptionPane.showMessageDialog(view, "Fundos insuficientes!");
               }
                   
               }


            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(view, "Falha de conexão!");
        }
        
    }    
}
