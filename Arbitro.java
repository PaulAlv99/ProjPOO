/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.util.Random;

/**
 *
 * @author Renato
 */
public class Arbitro extends Pessoa {
    private int idade = 0;
    private int experiencia = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    // Método para lançar a moeda ao ar e determinar o resultado (cara ou coroa)
    public String lancarMoedaAoAr() {
        Random lançamentoMoeda= new Random();
        int resultado = lançamentoMoeda.nextInt(2); // Gera 0 ou 1

        // Determina o resultado com base no valor gerado
        if (resultado == 0) {
            return "Cara";
        } else {
            return "Coroa";
        }
    }
}

