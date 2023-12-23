/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.util.*;

/**
 *
 * @author Paulo
 */
public class Lesoes {
    private String tipoLesao="";
    private String dataLesao="";
    
    public Lesoes(String TipoLesao,String DataLesao){
        this.tipoLesao=TipoLesao;
        this.dataLesao=DataLesao;
    }
    
    public String getTipoLesao(){
        return tipoLesao;
    }
    
    public void setLesao(String TipoLesao){
        this.tipoLesao=TipoLesao;
    }
    
    public String getDataLesao(){
        return dataLesao;
    }
    
    public void setDataLesao(String DataLesao){
        this.dataLesao=DataLesao;
    }
    
    @Override
    public String toString(){
        return "\nTipo de Lesao: " + tipoLesao +",Data Lesao: "+dataLesao;
    }
    
}
