package com.mycompany.poo.projetofase2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitura {

    public static List<Liga> lerDados(String[] nomesFicheiros) {
        List<Liga> ligas = new ArrayList<>();

        for (String nomeArquivo : nomesFicheiros) {
            Liga ligaAtual = null;
            String caminhoCompleto = "C:\\Users\\MSI\\Desktop\\" + nomeArquivo;

            try (BufferedReader br = new BufferedReader(new FileReader(new File(caminhoCompleto)))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    if (linha.startsWith(nomeArquivo.replace(".txt", ""))) {
                        // Nova liga
                        ligaAtual = new Liga(nomeArquivo.replace(".txt", ""));
                        ligaAtual.setNome(linha);

                        // Adiciona a liga à lista de ligas
                        ligas.add(ligaAtual);
                    } else if (ligaAtual != null && linha.startsWith("@")) {
                        // Jogadores
                        while ((linha = br.readLine()) != null && !linha.startsWith("@")) {
                            // Processar jogador (linha contendo nome e idade)
                            String[] partesJogador = linha.split("\\|");
                            if (partesJogador.length == 2) {
                                String nomeJogador = partesJogador[0];
                                int idadeJogador = Integer.parseInt(partesJogador[1]);

                                 // Criar um novo jogador e configurar atributos
            Jogador jogador = new Jogador(nomeJogador, idadeJogador);

                                if (ligaAtual != null && !ligaAtual.getequipas().isEmpty()) {
                           Equipa ultimaEquipa = ligaAtual.getequipas().get(ligaAtual.getequipas().size() - 1);
                           ultimaEquipa.getJogadoresLista().add(jogador);
                       }

                    } else if (ligaAtual != null && !linha.startsWith("@")) {
                        // Estatísticas da equipa
                        String[] partes = linha.split("\\|");
                        if (partes.length == 10) {
                            Equipa equipe = new Equipa();
                            Pessoa treinador = new Pessoa();
                            equipe.setNome(partes[1]);
                            equipe.setDesempenhoMed(Integer.parseInt(partes[2]));
                            equipe.setNumeroVitorias(Integer.parseInt(partes[3]));
                            equipe.setNumeroEmpates(Integer.parseInt(partes[4]));
                            equipe.setNumeroDerrotas(Integer.parseInt(partes[5]));
                            equipe.setNumeroGolos(Integer.parseInt(partes[6]));
                            equipe.setNumeroGolosSofridos(Integer.parseInt(partes[7]));
                            treinador.setNome(String.valueOf(partes[8]));
                            treinador.setIdade(Integer.parseInt(partes[9]));
                            // Adiciona a equipa à liga atual
                            ligaAtual.addequipa(equipe);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ligas;
    }

    public static void main(String[] args) {
        String[] nomesFicheiros = {"Espanhola.txt", "Equipas.txt", "Alemã.txt"};
        List<Liga> ligas = lerDados(nomesFicheiros);

     
    }
}