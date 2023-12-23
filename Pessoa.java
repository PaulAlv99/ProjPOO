/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;

/**
 *
 * @author Renato
 */
public class Pessoa {
    protected String nome="";
    protected int idade=0;
    public String GetNome(){
        return nome;
    }
    public void SetNome(String nome){
        this.nome=nome;
    }
    public int GetIdade(){
        return idade;
    }
    
    public void SetIdade(int idade){
        this.idade=idade;
    }
}
