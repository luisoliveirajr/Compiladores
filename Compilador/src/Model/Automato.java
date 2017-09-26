/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luís Oliveira
 */
public class Automato {
    private String Alfabeto;
    private String Conjunto_de_Simbolos;
    private Integer EstadoInicial;
    private List <Integer> EstadosFinais = new ArrayList<Integer>();
    private List <Transicao> MatrizdeTransicao = new ArrayList<Transicao>();

    public String getAlfabeto() {
        return Alfabeto;
    }

    public void setAlfabeto(String Alfabeto) {
        this.Alfabeto = Alfabeto;
    }

    public String getConjunto_de_Simbolos() {
        return Conjunto_de_Simbolos;
    }

    public void setConjunto_de_Simbolos(String Conjunto_de_Simbolos) {
        this.Conjunto_de_Simbolos = Conjunto_de_Simbolos;
    }

    public Integer getEstadoInicial() {
        return EstadoInicial;
    }

    public void setEstadoInicial(Integer EstadoInicial) {
        this.EstadoInicial = EstadoInicial;
    }

    public List <Integer> getEstadosFinais() {
        return EstadosFinais;
    }

    public void setEstadosFinais(List <Integer> EstadosFinais) {
        this.EstadosFinais = EstadosFinais;
    }

    public List <Transicao> getMatrizdeTransicao() {
        return MatrizdeTransicao;
    }

    public void setMatrizdeTransicao(List <Transicao> MatrizdeTransicao) {
        this.MatrizdeTransicao = MatrizdeTransicao;
    }    
}
