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
public class TreinadorPrincipal extends Treinador {
    private List<String> especializacoes = new ArrayList<String>();
    private List<String> taticaspref = new ArrayList<String>();
    private int moral = 0;
    
    public int getMoral() {
        return this.moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }
    
    public List<String> GetEspecializacoes(){
        return especializacoes;
    }
    
    public List<String> GetTaticaspref(){
        return taticaspref;
    }
    
    
    /*Adiciona especializacao e retorna todas as especializacoes*/
    public List<String> ADDEspecializacoes_LISTA(List<String> especializacoes,String especializacao){
        especializacoes.add(especializacao);
        
        return especializacoes;
    }
    
    /*Adiciona especializacao*/
    public void ADDEspecializacoes(List<String> especializacoes,String especializacao){
        especializacoes.add(especializacao);
    }
    
    public List<String> ADDTaticaPref_LISTA(List<String> taticaspref,String tatica){
        taticaspref.add(tatica);
        
        return taticaspref; 
    }
    
    public void ADDTaticaPref(List<String> taticaspref,String tatica){
        taticaspref.add(tatica);
    }
    
        
   public String toString(){
        return "Treinador: " + this.nome + "\nIdade: " + this.idade + "\nEquipa atual:"+this.getEquipaAtreinar()+"\nEspecializacoes: " + especializacoes +
                "\nTaticas preferidas: " + taticaspref;
        
    }
}
