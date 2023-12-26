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
                + "5. Estatísticas de Equipa" + "\n6. Sair");
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
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getTreinadorPrincipal().nome)){
                        System.out.println(ligas.get(j).getequipas().get(i).getTreinadorPrincipal());
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
    
    public void criarpartida(List <Liga> ligas){
        boolean continuar = false;
        Liga escolhida = new Liga();
        while(!continuar ){
            System.out.println("Digite a liga onde quer criar uma partida: ");
            String escolha = leitura.nextLine();
            for(int i = 0; i < ligas.size(); i ++){
                if(ligas.get(i).getNome().equals(escolha)){
                    continuar = true;
                    escolhida = ligas.get(i);
                    break;
                }
            }
            if(!continuar){
                System.out.println("Liga não existe");
            }
            else{
                System.out.println("Criando uma partida da liga escolhida...");
            }
        }
        if(escolhida.getequipas().size() >= 2){
        System.out.println("antes de atualizar jornada");
        escolhida.atualizarn_jornadas();
        System.out.println(escolhida.getjornada());
        System.out.println(escolhida.getequipas().size());
        System.out.println("antes de criar partida");
        escolhida.criarpartida();
        System.out.println("partida criada");
        Partida partida = escolhida.Getpartidas().get(escolhida.Getpartidas().size()-1);
        System.out.println("A partida criada foi: ");
        System.out.println(partida.toString());
        System.out.println("Executando partida...");
        if(partida.getequipa_casa().getJogadores().size() >= 11 && partida.getequipa_visitante().getJogadores().size() >= 11){
            partida.executarpartida();
        }
        else{
            if(partida.getequipa_casa().getJogadores().size() >= 11 && partida.getequipa_visitante().getJogadores().size() < 11){
                System.out.println("A equipa visitante não tem jogadores suficientes para iniciar a partida.");
                partida.getequipa_casa().setNumeroVitorias(partida.getequipa_casa().getNumeroVitorias() + 1);
                partida.getequipa_casa().setNumeroGolos(partida.getequipa_casa().getNumeroGolos() + 3);
                partida.getequipa_visitante().setNumeroDerrotas(partida.getequipa_visitante().getNumeroDerrotas() + 1);
                partida.getequipa_visitante().setNumeroGolosSofridos(partida.getequipa_visitante().getNumeroGolosSofridos() + 3);
                partida.setGolos_marcados_casa(partida.getGolos_marcados_casa() + 3);
                partida.setresultado();
                partida.terminou();
            }
            else if(partida.getequipa_visitante().getJogadores().size() >= 11 && partida.getequipa_casa().getJogadores().size() < 11){
                System.out.println("A equipa da casa não tem jogadores suficientes para iniciar a partida.");
                partida.getequipa_visitante().setNumeroVitorias(partida.getequipa_visitante().getNumeroVitorias() + 1);
                partida.getequipa_visitante().setNumeroGolos(partida.getequipa_visitante().getNumeroGolos() + 3);
                partida.getequipa_casa().setNumeroDerrotas(partida.getequipa_casa().getNumeroDerrotas() + 1);
                partida.getequipa_casa().setNumeroGolosSofridos(partida.getequipa_casa().getNumeroGolosSofridos() + 3);
                partida.setGolos_sofridos_casa(partida.getGolos_sofridos_casa() + 3);
                partida.setresultado();
                partida.terminou();
            }
            else if(partida.getequipa_visitante().getJogadores().size() < 11 && partida.getequipa_casa().getJogadores().size() < 11){
                System.out.println("Nenhuma das equipas tem jogadores suficientes para iniciar a partida.");
                partida.getequipa_casa().setNumeroEmpates(partida.getequipa_casa().getNumeroEmpates() + 1);
                partida.getequipa_visitante().setNumeroEmpates(partida.getequipa_visitante().getNumeroEmpates() + 1);
                partida.setresultado();
                partida.terminou();
            }
        }
        System.out.println("O resultado final da partida foi: ");
        System.out.println(partida.toString());
        }
        else{
            System.out.println("Esta liga não tem pelo meons 2 equipas");
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
                criarpartida(ligas);
                break;
            case 5:
                estatisticasEquipa(ligas);
                break;
            case 6:
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
        for(int i=0;i<ligas.get(indiceLiga).getequipas().size();i++){
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

    for (int k = 0; k < ligas.get(indiceLiga).getequipas().size(); k++) {
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
