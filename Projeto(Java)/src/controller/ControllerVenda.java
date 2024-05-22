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
import view.Venda;

/**
 *
 * @author unifnsilva
 */
public class ControllerVenda {
    private Connection conn;
    private UsuarioDAO dao = new UsuarioDAO(conn);
    private double novoSaldoReais, novoSaldoBit, novoSaldoRipple, novoSaldoEthereum;
    public ControllerVenda(Venda view){
        this.view = view;
        
    }
    private Venda view = new Venda();
        public void printCotacao() throws SQLException{
            
            ResultSet res = dao.consultarCotacao();
            Conexao conexao = new Conexao();
            if(res.next()){
                   String cotaBit = res.getString("cotabitcoin");
                   String cotaRipple = res.getString("cotaripple");
                   String cotaEthereum = res.getString("cotaethereum");
                   view.getLblBitcoin().setText("Bitcoin: " + cotaBit);
                   view.getLblRipple().setText("Ripple: " + cotaRipple);
                   view.getLblEthereum().setText("Ethereum: " + cotaEthereum);
            }
        }
        public void atualizar(String id, int CB, int CR, int CE) throws SQLException{
        double saque;
        double novoSaldoBit;
        int resultado = 0;
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
                   String cotaBit = res.getString("cotabitcoin");
                   String cotaRipple = res.getString("cotaripple");
                   String cotaEthereum = res.getString("cotaethereum");
                if(CB == 1){
                saque = Double.valueOf(view.getTxtBitcoin().getText());
                novoSaldoReais = Double.valueOf(saldo) + (saque*Double.valueOf(cotaBit)*0.98);
                novoSaldoBit = Double.valueOf(saldoBit) - saque;
                    if(novoSaldoBit >= 0){
                        carteira.setReais(Double.toString(novoSaldoReais));
                        carteira.setBit(Double.toString(novoSaldoBit));
                        resultado = 1;
                    }
                }if(CR == 1){
                    saque = Double.valueOf(view.getTxtRipple().getText());
                    novoSaldoReais = Double.valueOf(saldo) + (saque*Double.valueOf(cotaRipple)*0.99);
                    novoSaldoRipple = Double.valueOf(saldoRipple) - saque;
                    if(novoSaldoRipple >= 0){
                        carteira.setReais(Double.toString(novoSaldoReais));
                        carteira.setRipple(Double.toString(novoSaldoRipple));
                        resultado = 1;
                    }
                }if(CE == 1){
                     saque = Double.valueOf(view.getTxtEthereum().getText());
                     novoSaldoReais = Double.valueOf(saldo) - (saque*Double.valueOf(cotaEthereum)*0.99);
                     novoSaldoEthereum = Double.valueOf(saldoEthereum) + saque;
                        if(novoSaldoEthereum >= 0){
                        carteira.setReais(Double.toString(novoSaldoReais));
                        carteira.setEth(Double.toString(novoSaldoEthereum));
                        resultado = 1;
                    }
                }
                

             if(resultado == 1){

            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizarSaldo(Integer.parseInt(id),carteira);
             JOptionPane.showMessageDialog(view, "Saldo atual: " + carteira.getReais()
                     + "\n" + "Saldo de Bitcoin: " + carteira.getBit() + "\n" + 
                     "Saldo de Ripple: " + carteira.getRipple() + "\n" + 
                     "Saldo de Ethereum: " + carteira.getEth());
               }else{
                   JOptionPane.showMessageDialog(view, "Fundos insuficientes!");
               }
                   
               }


            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(view, "Falha de conexão!");
             System.out.println(e);
        }
        
    } 
}
