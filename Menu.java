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
public class Menu {
    Scanner leitura = new Scanner(System.in);
    public void opcoes(){
        System.out.println("1. Aceder informações de um jogador \n2. Aceder informações de um treinador \n"
                + "3. Aceder informações de uma equipa \n4. Criar uma partida \n"
                + "5. Associar uma equipa de futebol a uma Liga \n6. Estatísticas de Equipa\n7. Sair");
    }
    public boolean escolhavalida(String a){
        if(a.isEmpty()){
            return false;
        }
        else if(a.length() > 1){
            return false;
        }
        else if(a.length() == 1){
            int b = a.charAt(0); //converte char para o valir int da tabela ASCII
            if ((b >=49) && (b <= 57)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public void infojogador(String nome, List <Jogador> jogadores, int total ){
        for(int i=0; i<jogadores.size(); i++){
            if(nome.equals(jogadores.get(i).getNome())){
                break;
            }
        }
    }
    
    public void acederinfojogadores(List <Liga> ligas){
        System.out.println("Digite o nome completo do jogador: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                for(int k = 0; k<ligas.get(j).getequipas().get(i).getJogadoresLista().size(); k++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getJogadoresLista().get(k).getNome())){
                        ligas.get(j).getequipas().get(i).getJogadoresLista().get(k).mostrarinfojogador();
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                    }
        
                }   
            }
        if(!existe){
            System.out.println("Nome não existe!");
        }
    }
    
    public void acederinfotreinadores(List <Liga> ligas){
        System.out.println("Digite o nome completo do Treinador: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getTreinador().nome)){
                        System.out.println(ligas.get(j).getequipas().get(i).getTreinador());
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }   
            }
        if(!existe){
            System.out.println("Nome não existe!");
        }
    }
    
    public void acederinfoequipa(List <Liga> ligas){
        System.out.println("Digite o nome da equipa: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getNome())){
                        System.out.println(ligas.get(j).getequipas().get(i));
                        System.out.println("Jogadores:");
                        for(int k=0; k<ligas.get(j).getequipas().get(i).getJogadoresLista().size();k++){
                            ligas.get(j).getequipas().get(i).getJogadoresLista().get(k).mostrarinfojogador();
                        }
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }   
            }
        if(!existe){
            System.out.println("Nome não existe!");
        }
    }
    
    public void escolha(List <Liga> ligas,List <Equipa> equipas){
        System.out.println("Escolha uma das opções: ");
        String escolha = leitura.nextLine();
        boolean sair=true;
        while(!escolhavalida(escolha)&&sair){
            System.out.println("Opção inválida! Escolha uma opção entre 0 e 9: ");
            escolha = leitura.nextLine();
        }
        int escolhaint = escolha.charAt(0) - 48;
        switch(escolhaint){
            case 1:
                acederinfojogadores(ligas);
                break;
            case 2:
                acederinfotreinadores(ligas);
                break;
            case 3:
                acederinfoequipa(ligas);
                break;
            case 4:
                
                break;
            case 5:
                associarEquipaLiga(ligas,equipas);
                break;
            case 6:
                estatisticasEquipa(ligas);
                break;
            case 7:
                sair=false;
                break;
                
             
        }
    }
    
    public boolean nomeEquipaExistente(List <Equipa> equipas,String nomeDaEquipa){
        
        for(int i=0;i<equipas.size();i++){
            if(equipas.get(i).getNome()==nomeDaEquipa){
                return true;
            }
            
        }
        return false;
        
    }
    public int ligaExisteNomeEquipa(List <Liga> ligas,String nome){
       
        for(int i=0;i<ligas.size();i++){
            if(nome.equalsIgnoreCase(ligas.get(i).getNome())){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<String> equipasMesmaLiga(List <Liga> ligas,List <Equipa> equipas,String nome){
  
        ArrayList<String> temp=new ArrayList();
        for(int i=0;i<equipas.size();i++){
            if(equipas.get(i).getLiga().equalsIgnoreCase(nome)){
                temp.add(equipas.get(i).getNome());
            }
            
        }
        return temp;
    }
    public ArrayList<String> equipasDaLiga(List <Liga> ligas,String nome){
        int indiceLiga = ligaExisteNomeEquipa(ligas, nome);
        ArrayList<String> temp=new ArrayList();
        for(int i=0;i<ligas.get(indiceLiga).getn_equipas();i++){
            temp.add(ligas.get(indiceLiga).getequipas().get(i).getNome());
        }
        return temp;  
    }
    //funcao que remove o que está em comum entre duas Listas
    public void unicaEquipaQuePossoAdicionar(ArrayList<String> lista1,ArrayList<String> lista2){
        ArrayList<String> temp=new ArrayList();
        lista2.removeAll(lista1);  
    }
    
    //Equipas que estao na Liga
    public void associarEquipaLiga(List<Liga> ligas, List<Equipa> equipas) {
    System.out.println("Digite a Liga: ");
    String nome = leitura.nextLine();
    int indiceLiga = ligaExisteNomeEquipa(ligas, nome);
    if (indiceLiga == -1) {
        System.out.println("Liga não encontrada. Por favor, insira uma liga válida.");
        return;
    }
    ArrayList<String> listaTodasEquipaLiga = equipasDaLiga(ligas, nome);
    Collections.sort(listaTodasEquipaLiga);

    ArrayList<String> listaEquipasCriadas = equipasMesmaLiga(ligas, equipas, ligas.get(indiceLiga).getNome());
    Collections.sort(listaEquipasCriadas);
    unicaEquipaQuePossoAdicionar(listaTodasEquipaLiga, listaEquipasCriadas);

    System.out.println("Escolha a equipa que quer associar a uma liga:\n");
    String nomeEquipa;
    for (int i = 0; i < listaEquipasCriadas.size(); i++) {
        System.out.print((i + 1) + "-" + listaEquipasCriadas.get(i) + "\n");
    }
    String equipa = leitura.nextLine();
    int indiceEquipa = Integer.parseInt(equipa) - 1;
    nomeEquipa = listaEquipasCriadas.get(indiceEquipa);
    Equipa equipaAAdicionar = null;

    for (int l = 0; l < equipas.size(); l++) {
        if (equipas.get(l).getLiga().equalsIgnoreCase(nome)) {
            if (nomeEquipa.equalsIgnoreCase(equipas.get(l).getNome())) {
                equipaAAdicionar = equipas.get(l);
            }
        }
    }

    ligas.get(indiceLiga).addequipa(equipaAAdicionar);

    for (int k = 0; k < ligas.get(indiceLiga).getn_equipas(); k++) {
        System.out.println("\n"+ligas.get(indiceLiga).getequipas().get(k));
    }
}
public void estatisticasEquipa(List <Liga> ligas){
        System.out.println("Digite o nome da equipa: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getNome())){
                        System.out.println(ligas.get(j).getequipas().get(i));
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }   
            }
        if(!existe){
            System.out.println("Equipa não existe!");
        }
    }
    
}
