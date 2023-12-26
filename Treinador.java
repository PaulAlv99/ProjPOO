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
public class Treinador extends Pessoa {
    private int overall = 0;
    private String equipaAtreinar="";

    public int getOverall() {
        return overall;
    }

    public String getEquipaAtreinar() {
        return equipaAtreinar;
    }

    public void setEquipaAtreinar(String equipaAtreinar) {
        this.equipaAtreinar = equipaAtreinar;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
}
