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
public class Ataque {
    private int golos = 0;
    private int assistencias = 0;
    private int passes_certos = 0;
    private int dribles_certos = 0;

    public int getGolos() {
        return golos;
    }

    public void setGolos(int golos) {
        this.golos = golos;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getPasses_certos() {
        return passes_certos;
    }

    public void setPasses_certos(int passes_certos) {
        this.passes_certos = passes_certos;
    }

    public int getDribles_certos() {
        return dribles_certos;
    }

    public void setDribles_certos(int dribles_certos) {
        this.dribles_certos = dribles_certos;
    }
    public void mostrarInfoAtaque() {
    System.out.println("Golos: " + golos);
    System.out.println("\nAssistências: " + assistencias);
    System.out.println("\nPasses certos: " + passes_certos);
    System.out.println("\ndribles_certos: " + dribles_certos);
    }
}
