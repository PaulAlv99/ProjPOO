/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.util.*;

/**
 *
 * @author Renato
 */
public class Defesa {
    private int cortes_certos = 0;
    private int golos_impedidos = 0;
    private int carrinhos_certos = 0;
    private int cartoes = 0;
    private int bolas_recuperadas = 0;
    public void mostrarInfoDefesa(){
        System.out.println("Cortes certos: " + cortes_certos);
        System.out.println("Golos impedidos: " + golos_impedidos);
        System.out.println("Carrinhos certos: " + carrinhos_certos);
        System.out.println("Cartões: " + cartoes);
        System.out.println("Bolas recuperadas: " + bolas_recuperadas);
    }

    public int getCortes_certos() {
        return cortes_certos;
    }

    public void setCortes_certos(int cortes_certos) {
        this.cortes_certos = cortes_certos;
    }

    public int getGolos_impedidos() {
        return golos_impedidos;
    }

    public void setGolos_impedidos(int golos_impedidos) {
        this.golos_impedidos = golos_impedidos;
    }

    public int getCarrinhos_certos() {
        return carrinhos_certos;
    }

    public void setCarrinhos_certos(int carrinhos_certos) {
        this.carrinhos_certos = carrinhos_certos;
    }

    public int getCartoes() {
        return cartoes;
    }

    public void setCartoes(int cartoes) {
        this.cartoes = cartoes;
    }

    public int getBolas_recuperadas() {
        return bolas_recuperadas;
    }

    public void setBolas_recuperadas(int bolas_recuperadas) {
        this.bolas_recuperadas = bolas_recuperadas;
    }
}
