/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo.projetofase2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class PooProjetofase2 {

    public static void main(String[] args) {
        Menu menu = new Menu();
        //menu.opcoes();
//        Equipa BENFICA = new Equipa();
//        BENFICA.setLiga("Portuguesa");
//        BENFICA.setNome("Benfica");
        List <Equipa> equipas = new ArrayList<>();
        List <TreinadorPrincipal> treinadores = new ArrayList<>();
        List <Jogador> jogadores = new ArrayList<>();
        List <Arbitro> arbitros = new ArrayList<>();
        List <Liga> ligas = new ArrayList();
//        equipas.add(BENFICA);
//        BENFICA.setTreinador("Lucas",90);
//        BENFICA.getTreinador().setNome("ANIBAL");
//        BENFICA.getTreinador().ADDEspecializacoes(BENFICA.getTreinador().GetEspecializacoes(),"sábio");
//        BENFICA.getTreinador().ADDTaticaPref(BENFICA.getTreinador().GetTaticaspref(),"4-2-2");
//        int temp=BENFICA.getJogadoresLista().size();
//        BENFICA.getJogadoresLista().add(new Jogador("Paulo",10,"S",10));
//        BENFICA.getJogadoresLista().add(new Jogador("S",10,"S",10));
//        
        Liga Portuguesa = new Liga("Portuguesa");
        Liga Espanhola = new Liga("Espanhola");
//        Portuguesa.addequipa(BENFICA);
        Equipa porto = new Equipa("porto","Portuguesa");
        equipas.add(porto);
        Equipa benfica = new Equipa("benfica","Portuguesa");
        equipas.add(benfica);
//        Equipa braga = new Equipa("braga","Portuguesa");
//        equipas.add(braga);
//        Equipa famalicao = new Equipa("famalicao","Portuguesa");
//        equipas.add(famalicao);
//        Equipa vitoria = new Equipa("vitoria","Portuguesa");
//        equipas.add(vitoria);
        Equipa barcelona = new Equipa("barcelona","Espanhola");
        equipas.add(barcelona);
//        Equipa valencia = new Equipa("valencia","Espanhola");
//        equipas.add(valencia);
        Espanhola.addequipa(barcelona);
        Portuguesa.addequipa(porto);
        Portuguesa.addequipa(benfica);
        ligas.add(Espanhola);
        ligas.add(Portuguesa);
        //menu.escolha(ligas,equipas);
        jogadores.add(new Jogador("Paulo",21,"GK",50));
        jogadores.add(new Jogador("Lucas",21,"DEFESA",50));
        jogadores.add(new Jogador("Renato",21,"MEDIO",50));
        jogadores.add(new Jogador("Gabriel",21,"ATACANTE",50));
        jogadores.add(new Jogador("Manel",21,"GK",50));
        jogadores.add(new Jogador("Ribeiro",21,"DEFESA",50));
        jogadores.add(new Jogador("Lopes",21,"MEDIO",50));
        jogadores.add(new Jogador("Antonio",21,"ATACANTE",50));
        jogadores.add(new Jogador("Paulino",21,"MEDIO",50));
        jogadores.add(new Jogador("Paula",21,"ATACANTE",50));
        jogadores.add(new Jogador("Jubas",21,"MEDIO",50));
        jogadores.add(new Jogador("Pilantra",21,"ATACANTE",50));
        SubMenu subMenu = new SubMenu();
        while(true){
        subMenu.opcoes();
        subMenu.escolha(ligas, equipas, treinadores, jogadores, arbitros);
        }
    }
}
