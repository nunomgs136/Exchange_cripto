/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifnsilva
 */
public class Carteira extends Usuario{
    private String reais,bit,ripple, eth, cpf, nome;
    private int id;

    public Carteira(String reais, String bit, String ripple, String eth) {
        this.reais = reais;
        this.bit = bit;
        this.ripple = ripple;
        this.eth = eth;
    }

    public Carteira(String reais, String bit, String ripple, String eth, int id, String nome, String cpf) {
        super(Integer.toString(id));
        this.reais = reais;
        this.bit = bit;
        this.ripple = ripple;
        this.eth = eth;
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public Carteira() {
    }

    public String getReais() {
        return reais;
    }

    public void setReais(String reais) {
        this.reais = reais;
    }

    public String getBit() {
        return bit;
    }

    public void setBit(String bit) {
        this.bit = bit;
    }

    public String getRipple() {
        return ripple;
    }

    public void setRipple(String ripple) {
        this.ripple = ripple;
    }

    public String getEth() {
        return eth;
    }

    public void setEth(String eth) {
        this.eth = eth;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String deposito(int valor){
        int novoSaldo = valor + Integer.valueOf(reais);
        setReais(Integer.toString(novoSaldo));
        return Integer.toString(novoSaldo);
    }
}
