/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Renato
 */
public class Equipa {
    private String nome = "";
    private String Liga="";
    private int desempenhoMedio=0;
    private int numeroVitorias=0;
    private int numeroEmpates=0;
    private int numeroDerrotas=0;
    private int numeroGolos=0;
    private int numeroGolosSofridos=0;
    private String tatica = ""; 
    private List<Jogador> jogadores=new ArrayList<Jogador>();
    private Treinador treinador=new Treinador();
    //significa que a classe em si o numero maximo de jogadores é 11,dai o uso de static
    //static ou seja pertence à classe e não à instancia
    private static final int MAX_JOGADORES = 11;
    
    public Equipa(){
        
    }
    public Equipa(String nome,String Liga){
        this.nome=nome;
        this.Liga=Liga;
    }
    public Equipa(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getNumeroGolos(){
        return numeroGolos;
    }
    
    public int getNumeroGolosSofridos(){
        return numeroGolosSofridos;
    }
    
    public int getNumeroVitorias(){
        return numeroVitorias;
    }
    
    public int getNumeroDerrotas(){
        return numeroDerrotas;
    }
    
    public int getNumeroEmpates(){
        return numeroEmpates;
    }
    
    public int getDesempenhoMED(){
        return desempenhoMedio;
    }
    
    public String getLiga(){
        return Liga;
    }
    
    public Treinador getTreinador(){
        return treinador;
    }
    
    public void setNumeroGolos(int NumeroGolos) {
        this.numeroGolos = NumeroGolos;
    }

    public void setNumeroGolosSofridos(int NumeroGolosSofridos) {
        this.numeroGolosSofridos = NumeroGolosSofridos;
    }

    public void setNumeroVitorias(int NumeroVitorias) {
        this.numeroVitorias = NumeroVitorias;
    }

    public void setNumeroDerrotas(int NumeroDerrotas) {
        this.numeroDerrotas = NumeroDerrotas;
    }

    public void setNumeroEmpates(int NumeroEmpates) {
        this.numeroEmpates = NumeroEmpates;
    }
    public void setDesempenhoMed(int DesempenhoMED) {
        this.desempenhoMedio = DesempenhoMED;
    }
    
    public List<Jogador> getJogadoresLista(){
        return jogadores;
    }
    
    public void setLiga(String Liga){
        this.Liga=Liga;
    }
    
    public void setTreinador(String nome,int idade){
        treinador.SetNome(nome);
        treinador.SetIdade(idade);
    }
    
    public String toString(){
        return "Equipa: " + nome + "\nTreinador: " + treinador.GetNome() + "\nLiga: " + Liga + 
                "\nDesempenho médio: " + desempenhoMedio + "\nNumero de vitorias: " + numeroVitorias 
                +"\nNumero de derrotas: " + numeroDerrotas +
                "\nNumero de empates: " + numeroEmpates +
                "\nNumero de golos marcados: " + numeroGolos +
                "\nNumero de golos sofridos: " + numeroGolosSofridos;
        
    }
    
    public int n_jogos(){
        int n_jogos = this.numeroDerrotas + this.numeroEmpates + this.numeroVitorias;
        return n_jogos;
    }
    
    
    
    public void definir_tatica(){
        int n_atacantes = 0;
        int n_medios = 0;
        int n_defesas = 0;
        for (int i = 0; i<this.jogadores.size(); i++){
            if(this.jogadores.get(i).getPosJogador() == "medio"){
                n_medios = n_medios + 1;
            }
            else if(this.jogadores.get(i).getPosJogador() == "atacante"){
                n_atacantes = n_atacantes + 1;
            }
            else if(this.jogadores.get(i).getPosJogador() == "defesa"){
                n_defesas = n_defesas + 1;
            }
        }
        if(n_medios + n_atacantes + n_defesas == 10){
           this.tatica = n_defesas + "-" + n_medios + "-" + n_atacantes; 
        }
        else{
            System.out.println("Numero de jogadores invalido");
        }
    }
    
    public String get_tatica(){
        return this.tatica;
    }
    
    public void alterar_moral_treinador(){
        boolean tatica_preferida = false;
        for(int i = 0; i < this.treinador.GetTaticaspref().size() ; i++){
            if(this.treinador.GetTaticaspref().get(i).equals(this.tatica)){
                tatica_preferida = true;
                break;
            }
        }
        int overall = this.treinador.getOverall();
        if(!tatica_preferida){
            if(overall > 10){
                this.treinador.setMoral(overall - 10);
            }
            else{
                this.treinador.setMoral(1);
            }
        }
        else{
            this.treinador.setMoral(overall);
        }
    }
    
}
