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
public class Partida {
    private String data;
    private Equipa equipa_casa;
    private Equipa equipa_visitante;
    private String resultado;
    private int golos_sofridos_casa;
    private int golos_marcados_casa;
    private boolean terminada = false;
    
    public Equipa getequipa_casa(){
        return this.equipa_casa;
    }
    
    public Equipa getequipa_visitante(){
        return this.equipa_visitante;
    }
    
    public void setequipa_visitante(Equipa a){
        this.equipa_visitante = a;
    }
    public void setequipa_casa(Equipa a){
        this.equipa_casa = a;
    }
    
    public void setdata(String data){
        this.data = data;
    }
    
    public int chance_golo(Equipa a){
        a.definir_tatica();
        a.alterar_moral_treinador();
        Random aleatorio = new Random();
        int chances_minimas = (14 * a.getTreinador().getMoral()) / 100;
        int chances_maximas = (24 *a.getTreinador().getMoral()) / 100;
        int chances_golo = aleatorio.nextInt(chances_maximas - chances_minimas) + chances_minimas;
        return chances_golo;
    }
    
    public int probabilidade_marcar_golo(Equipa a){
        int probabilidade = 0;
        Random aleatorio = new Random();
        for(int i = 0; i<a.getJogadoresLista().size(); i++){
            if(a.getJogadoresLista().get(i).getPosJogador() == "GR"){
                probabilidade = probabilidade + (aleatorio.nextInt(1-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador() == "defesa"){
                probabilidade = probabilidade + (aleatorio.nextInt(8-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador() == "medio"){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(31-10)+10)) / 100); 
            }
            else if(a.getJogadoresLista().get(i).getPosJogador() == "atacante"){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(61-31)+31)) / 100);
            }
        }
        return probabilidade;
    }
    
    public int probabilidade_defender_golo(Equipa a){
        int probabilidade = 0;
        Random aleatorio = new Random();
        for(int i = 0; i<a.getJogadoresLista().size(); i++){
            if(a.getJogadoresLista().get(i).getPosJogador() == "atacante"){
                probabilidade = probabilidade + (aleatorio.nextInt(1-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador() == "medio"){
                probabilidade = probabilidade + (aleatorio.nextInt(8-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador() == "defesa"){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(31-10)+10)) / 100); 
            }
            else if(a.getJogadoresLista().get(i).getPosJogador() == "GR"){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(61-31)+31)) / 100);
            }
        }
        return probabilidade;
    }
    
    public void golos(){
        int chance_golo_casa = chance_golo(this.equipa_casa);
        int chance_golo_visitante = chance_golo(this.equipa_visitante);
        Random aleatorio = new Random();
        for(int i = 0; i < chance_golo_casa; i ++){
            if(probabilidade_marcar_golo(this.equipa_casa) > probabilidade_defender_golo(this.equipa_visitante)){
                this.golos_marcados_casa = this.golos_marcados_casa + 1;
                int chance_marcar_golo = -1;
                int chance_assistir = -1;
                Jogador marcador = new Jogador("", 0, "", 0);
                Jogador assistente = new Jogador("", 0, "", 0);
                //fazer uma chance pra saber qual jogador da casa marcou o golo
                for(int j=0; j < this.equipa_casa.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_casa.getJogadoresLista().get(j);
                    int chance_marcar_golo_atual = 0;
                    if(jogador_atual.getPosJogador() == "GR"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(1-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "defesa"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(8-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "medio"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "atacante"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    if(chance_marcar_golo_atual > chance_marcar_golo){
                        chance_marcar_golo = chance_marcar_golo_atual;
                        marcador = jogador_atual;
                    }
                    else if(chance_marcar_golo_atual > chance_assistir){
                        chance_assistir = chance_marcar_golo_atual;
                        assistente = jogador_atual;
                    }
                }
                marcador.getInfo_ataque().setGolos(marcador.getInfo_ataque().getGolos() + 1);
                assistente.getInfo_ataque().setAssistencias(assistente.getInfo_ataque().getAssistencias() + 1);
            }
            else{ //nao ha golo - ver quem defendeu
                int chance_defender_golo = -1;
                Jogador defensor = new Jogador("", 0, "", 0);
                for(int j=0; j < this.equipa_visitante.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_visitante.getJogadoresLista().get(j);
                    int chance_defender_golo_atual = 0;
                    if(jogador_atual.getPosJogador() == "GR"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "defesa"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "medio"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(30-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "atacante"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(1-0)+0);
                    }
                    if(chance_defender_golo_atual > chance_defender_golo){
                        chance_defender_golo = chance_defender_golo_atual;
                        defensor = jogador_atual;
                    }
                    defensor.getInfo_defesa().setGolos_impedidos(defensor.getInfo_defesa().getGolos_impedidos() + 1);
            }
            }
        }
        for(int i = 0; i < chance_golo_visitante; i ++){
            if(probabilidade_marcar_golo(this.equipa_visitante) > probabilidade_defender_golo(this.equipa_casa)){
                this.golos_sofridos_casa = this.golos_sofridos_casa + 1;
                int chance_marcar_golo = -1;
                int chance_assistir = -1;
                Jogador marcador = new Jogador("", 0, "", 0);
                Jogador assistente = new Jogador("", 0, "", 0);
                //fazer uma chance pra saber qual jogador da casa marcou o golo
                for(int j=0; j < this.equipa_visitante.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_visitante.getJogadoresLista().get(j);
                    int chance_marcar_golo_atual = 0;
                    if(jogador_atual.getPosJogador() == "GR"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(1-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "defesa"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(8-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "medio"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "atacante"){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    if(chance_marcar_golo_atual > chance_marcar_golo){
                        chance_marcar_golo = chance_marcar_golo_atual;
                        marcador = jogador_atual;
                    }
                    else if(chance_marcar_golo_atual > chance_assistir){
                        chance_assistir = chance_marcar_golo_atual;
                        assistente = jogador_atual;
                    }
                }
                marcador.getInfo_ataque().setGolos(marcador.getInfo_ataque().getGolos() + 1);
                assistente.getInfo_ataque().setAssistencias(assistente.getInfo_ataque().getAssistencias() + 1);
            }
            else{ //nao ha golo - ver quem defendeu
                int chance_defender_golo = -1;
                Jogador defensor = new Jogador("", 0, "", 0);
                for(int j=0; j < this.equipa_casa.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_casa.getJogadoresLista().get(j);
                    int chance_defender_golo_atual = 0;
                    if(jogador_atual.getPosJogador() == "GR"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "defesa"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "medio"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(30-0)+0);
                    }
                    else if(jogador_atual.getPosJogador() == "atacante"){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(1-0)+0);
                    }
                    if(chance_defender_golo_atual > chance_defender_golo){
                        chance_defender_golo = chance_defender_golo_atual;
                        defensor = jogador_atual;
                    }
                    defensor.getInfo_defesa().setGolos_impedidos(defensor.getInfo_defesa().getGolos_impedidos() + 1);
            }
            }
            }
        }
    public void atualizar_infos_equipas(){ // alterar golos das equipas e n de vitorias...
        if(terminada){
            if(this.golos_marcados_casa > this.golos_sofridos_casa){
                this.equipa_casa.setNumeroVitorias(this.equipa_casa.getNumeroVitorias() + 1);
                this.equipa_visitante.setNumeroDerrotas(this.equipa_visitante.getNumeroDerrotas() + 1);
            }
            else if(this.golos_marcados_casa < this.golos_sofridos_casa){
                this.equipa_visitante.setNumeroVitorias(this.equipa_visitante.getNumeroVitorias() + 1);
                this.equipa_casa.setNumeroDerrotas(this.equipa_casa.getNumeroDerrotas() + 1);
            }
            else if(this.golos_marcados_casa == this.golos_sofridos_casa){
                this.equipa_casa.setNumeroEmpates(this.equipa_casa.getNumeroEmpates() + 1);
                this.equipa_visitante.setNumeroEmpates(this.equipa_visitante.getNumeroEmpates() + 1);
            }
            this.equipa_casa.setNumeroGolos(this.equipa_casa.getNumeroGolos() + this.golos_marcados_casa);
            this.equipa_casa.setNumeroGolosSofridos(this.equipa_casa.getNumeroGolosSofridos() + this.golos_sofridos_casa);
            this.equipa_visitante.setNumeroGolos(this.equipa_visitante.getNumeroGolos() + this.golos_sofridos_casa);
            this.equipa_visitante.setNumeroGolosSofridos(this.equipa_visitante.getNumeroGolosSofridos() + this.golos_marcados_casa);            
        }
        else{
            System.out.println("A Partida ainda não terminou");
        }
    }
    public void estatisticas_defensivas(){
        Random aleatorio = new Random();
        for(int i = 0; i < this.equipa_casa.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_casa.getJogadoresLista().get(i);
            if(atual.getPosJogador() == "GR"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(1-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador() == "defesa"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(20-6)+6));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(10-3)+3));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(20-6)+6));
            }
            else if(atual.getPosJogador() == "medio"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(12-2)+2));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(7-1)+1));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(12-2)+2));
            }
            else if(atual.getPosJogador() == "atacante"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(5-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(5-0)+0));
            }
        }
    for(int i = 0; i < this.equipa_visitante.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_visitante.getJogadoresLista().get(i);
            if(atual.getPosJogador() == "GR"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(1-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador() == "defesa"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(20-6)+6));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(10-3)+3));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(20-6)+6));
            }
            else if(atual.getPosJogador() == "medio"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(12-2)+2));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(7-1)+1));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(12-2)+2));
            }
            else if(atual.getPosJogador() == "atacante"){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(5-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(5-0)+0));
            }
        }
    }
    
    public void estatisticas_ofensivas(){
        Random aleatorio = new Random();
        for(int i = 0; i < this.equipa_casa.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_casa.getJogadoresLista().get(i);
            if(atual.getPosJogador() == "GR"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(8-2)+2));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador() == "defesa"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(15-5)+5));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(5-0)+0));
            }
            else if(atual.getPosJogador() == "medio"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(30-10)+10));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(10-2)+2));
            }            
            else if(atual.getPosJogador() == "ataque"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(25-8)+8));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(20-5)+5));
            }
            
    }
    for(int i = 0; i < this.equipa_visitante.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_visitante.getJogadoresLista().get(i);
            if(atual.getPosJogador() == "GR"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(8-2)+2));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador() == "defesa"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(15-5)+5));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(5-0)+0));
            }
            else if(atual.getPosJogador() == "medio"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(30-10)+10));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(10-2)+2));
            }            
            else if(atual.getPosJogador() == "ataque"){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(25-8)+8));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(20-5)+5));
            }
            
    }
    }
    
    public void executarpartida(){
        if(!this.terminada){
            golos();
            atualizar_infos_equipas();
            estatisticas_defensivas();
            estatisticas_ofensivas();
            this.terminada = true;
        }
        else{
            System.out.println("Esta partida já foi disputada anteriormente!");
        }
    }
}
    
//    public String criardataaleatoria(){
//        Random aleatorio = new Random();
//        int mes = aleatorio.nextInt(12 - 1) + 1;
//        int ano = aleatorio.nextInt(2100 - 2024) + 2024;
//        boolean bissexto = false;
//        int dia = 0;
//        if(ano%400 == 0){
//            bissexto = true;
//        }
//        else if(ano%100 == 0){
//            bissexto = false;
//        }
//        else if(ano%4 == 0){
//            bissexto = true;
//        }
//        else{
//            bissexto = false;
//        }
//        if(mes == 2 && bissexto){
//            dia = aleatorio.nextInt(29 - 1) + 1;
//        }
//        else if(mes == 2 && !bissexto){
//            dia = aleatorio.nextInt(28 - 1) + 1;
//        }
//        else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
//            dia = aleatorio.nextInt(31 - 1) + 1;
//        }
//        else{
//            dia = aleatorio.nextInt(30 - 1) + 1;
//        }
//        String data = dia + "-" + mes + "-" + ano;
//        return data;
//    }

//}
