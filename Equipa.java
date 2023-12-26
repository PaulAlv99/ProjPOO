/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
    private TreinadorPrincipal treinadorprincipal=new TreinadorPrincipal();
    private TreinadorAssistente treinadorassistente = new TreinadorAssistente();
    //significa que a classe em si o numero maximo de jogadores é 11,dai o uso de static
    //static ou seja pertence à classe e não à instancia
    private int n_jogadores_disponiveis = 0;
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
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    public void addJogadores(List<Jogador> jogadores, Jogador jogador) {
    if (this.jogadores.size() < MAX_JOGADORES) {
        if (!jogadorEstaNaEquipa(jogadores, jogador)) {
            jogador.setEquipa(this.getNome());
            this.jogadores.add(jogador);
        } else {
            System.out.println("Jogador já encontra-se na equipa");
        }
    } else {
        System.out.println("Equipa cheia");
    }
}

public boolean jogadorEstaNaEquipa(List<Jogador> jogadores, Jogador jogador) {
    return this.jogadores.contains(jogador);
}
    public void removeJogadores(List<Jogador> jogadores,Jogador jogador){
        for(int i=0;i<jogadores.size();i++){
            if(jogadores.get(i).getNome().equalsIgnoreCase(jogador.getNome())){
                jogadores.remove(i);
                break;
            }
        }
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
    
    public TreinadorPrincipal getTreinadorPrincipal(){
        return this.treinadorprincipal;
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
        this.treinadorprincipal.setNome(nome);
        this.treinadorprincipal.setIdade(idade);
    }
    public void setTreinadorPrincipal(TreinadorPrincipal treinador){
        this.treinadorprincipal=treinador;
        this.treinadorprincipal.setEquipaAtreinar(this.getNome());
        
    }
    
    public String toString(){
        return "Equipa: " + nome + "\nTreinador: " + treinadorprincipal.getNome() + "\nLiga: " + Liga + 
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
            if(this.jogadores.get(i).getPosJogador() == "MEDIO"){
                n_medios = n_medios + 1;
            }
            else if(this.jogadores.get(i).getPosJogador() == "ATACANTE"){
                n_atacantes = n_atacantes + 1;
            }
            else if(this.jogadores.get(i).getPosJogador() == "DEFESA"){
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
        for(int i = 0; i < this.treinadorprincipal.GetTaticaspref().size() ; i++){
            if(this.treinadorprincipal.GetTaticaspref().get(i).equals(this.tatica)){
                tatica_preferida = true;
                break;
            }
        }
        int overall = this.treinadorprincipal.getOverall();
        if(!tatica_preferida){
            if(overall > 10){
                this.treinadorprincipal.setMoral(overall - 10);
            }
            else{
                this.treinadorprincipal.setMoral(1);
            }
        }
        else{
            this.treinadorprincipal.setMoral(overall);
        }
    }
    
    
    public void treinarjogadores(){
        Random aleatorio = new Random();
        //(aleatorio.nextInt(1-0)+0)
        for(int i = 0; i < this.jogadores.size(); i++){
            if(this.treinadorassistente.getPosicaopreferida() == this.jogadores.get(i).getPosJogador()){
                
            }
        }
    }
}
