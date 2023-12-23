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
        menu.opcoes();
        Equipa BENFICA = new Equipa();
        BENFICA.setLiga("Portuguesa");
        BENFICA.setNome("Benfica");
        List <Equipa> equipas = new ArrayList<>();
        equipas.add(BENFICA);
        BENFICA.setTreinador("Lucas",90);
        BENFICA.getTreinador().SetNome("ANIBAL");
        BENFICA.getTreinador().ADDEspecializacoes(BENFICA.getTreinador().GetEspecializacoes(),"sábio");
        BENFICA.getTreinador().ADDTaticaPref(BENFICA.getTreinador().GetTaticaspref(),"4-2-2");
        int temp=BENFICA.getJogadoresLista().size();
        BENFICA.getJogadoresLista().add(new Jogador("Paulo",10,"S",10));
        BENFICA.getJogadoresLista().add(new Jogador("S",10,"S",10));
        List <Liga> ligas = new ArrayList();
        Liga Portuguesa = new Liga("Portuguesa");
        Liga Espanhola = new Liga("Espanhola");
        Portuguesa.addequipa(BENFICA);
        Equipa porto = new Equipa("porto","Portuguesa");
        equipas.add(porto);
        Equipa braga = new Equipa("braga","Portuguesa");
        equipas.add(braga);
        Equipa famalicao = new Equipa("famalicao","Portuguesa");
        equipas.add(famalicao);
        Equipa vitoria = new Equipa("vitoria","Portuguesa");
        equipas.add(vitoria);
        Equipa barcelona = new Equipa("barcelona","Espanhola");
        equipas.add(barcelona);
        Equipa valencia = new Equipa("valencia","Espanhola");
        equipas.add(valencia);
        Espanhola.addequipa(barcelona);
        Portuguesa.addequipa(porto);
        ligas.add(Espanhola);
        ligas.add(Portuguesa);
        menu.escolha(ligas,equipas);
    }
}
