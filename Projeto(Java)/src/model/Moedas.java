/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author unifnsilva
 */
public class Moedas {
    int cotabit, cotaripple, cotaethereum;

    public Moedas(int cotabit, int cotaripple, int cotaethereum) {
        this.cotabit = cotabit;
        this.cotaripple = cotaripple;
        this.cotaethereum = cotaethereum;
    }

    public int getCotabit() {
        return cotabit;
    }

    public void setCotabit(int cotabit) {
        this.cotabit = cotabit;
    }

    public int getCotaripple() {
        return cotaripple;
    }

    public void setCotaripple(int cotaripple) {
        this.cotaripple = cotaripple;
    }

    public int getCotaethereum() {
        return cotaethereum;
    }

    public void setCotaethereum(int cotaethereum) {
        this.cotaethereum = cotaethereum;
    }
    
}
