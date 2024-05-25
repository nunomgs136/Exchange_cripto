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
import java.util.*;
import model.Moedas;
import view.Atualizar;
/**
 * Através do acesso ao banco de dados, o controller atualiza as cotações das 
 * criptomoedas,sendo um número aleatório que tem em conta que deve ser uma 
 * diferença menor do que 5% da cotação anterior, isto sendo feito com um if 
 * statement. Após ser verificado e sendo refeita a operação se a cotação escolhida
 * for fora do intervalo mencionado, é atualizada a cotação de cada moeda no banco
 * de dados feito pelo DAO.
 * 
 * 
 * @author unifnsilva
 */
public class ControllerAtualizar {
    private Connection conn;
    private UsuarioDAO dao = new UsuarioDAO(conn);
    private Atualizar view = new Atualizar();
    private String cotaBit, cotaRipple, cotaEthereum;
    public ControllerAtualizar(Atualizar view){
        this.view = view;
    }
    public void printCotacao() throws SQLException{
       ResultSet res = dao.consultarCotacao();
                   Conexao conexao = new Conexao();
            if(res.next()){
                   cotaBit = res.getString("cotabitcoin");
                   cotaRipple = res.getString("cotaripple");
                   cotaEthereum = res.getString("cotaethereum");
                   view.getLblBitcoin().setText("Bitcoin: " + cotaBit);
                   view.getLblRipple().setText("Ripple: " + cotaRipple);
                   view.getLblEthereum().setText("Ethereum: " + cotaEthereum);
            }
       
    }
    public void atualizar() throws SQLException{
               ResultSet res = dao.consultarCotacao();
                   Conexao conexao = new Conexao();
            if(res.next()){
                   cotaBit = res.getString("cotabitcoin");
                   cotaRipple = res.getString("cotaripple");
                   cotaEthereum = res.getString("cotaethereum");
                   Moedas cotas = new Moedas(cotaBit, cotaRipple, cotaEthereum);
                   String novaCotaBit = Double.toString(Math.random());
                   String novaCotaRipple = Double.toString(Math.random());
                   String novaCotaEthereum = Double.toString(Math.random());
                   while(Double.valueOf(novaCotaBit) >= Double.valueOf(cotaBit) * 1.05 && Double.valueOf(novaCotaBit) <= 0.95 * Double.valueOf(cotaBit)&&
                          Double.valueOf(novaCotaRipple) >= Double.valueOf(cotaRipple) * 1.05 && Double.valueOf(novaCotaRipple) <= 0.95 * Double.valueOf(cotaRipple) &&
                          Double.valueOf(novaCotaEthereum) <= Double.valueOf(cotaEthereum) * 1.05 && Double.valueOf(novaCotaEthereum) >= 0.95 * Double.valueOf(cotaEthereum) ){
                    novaCotaBit = Double.toString(Math.random());
                    novaCotaRipple = Double.toString(Math.random());
                    novaCotaEthereum = Double.toString(Math.random());

                           }
                   cotas.setCotaBit(novaCotaBit);
                   cotas.setCotaRipple(novaCotaRipple);
                   cotas.setCotaEthereum(novaCotaEthereum);
                   dao.atualizarCotacao(cotas);
                   view.getLblBitcoin().setText("Bitcoin: " + novaCotaBit);
                   view.getLblRipple().setText("Ripple: " + novaCotaRipple);
                   view.getLblEthereum().setText("Ethereum: " + novaCotaEthereum); 
                       }
                    
  
                   }

            }
    
       
            
    

