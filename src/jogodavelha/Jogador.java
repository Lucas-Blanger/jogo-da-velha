/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

/**
 *
 * @author 02902564023
 */
public class Jogador {
    
    private String nome;
    private char simbolo;
    private Tabuleiro tabuleiro;
    Interface ig = new Interface();
    
    public Jogador(String nome, Tabuleiro tabuleiro, char simbolo){
        this.nome = nome;
        this.simbolo = simbolo;
        this.tabuleiro = tabuleiro;
    }
    
    public boolean realizarJogada(){
        Movimento m = realizarMovimento();
        return tabuleiro.marcarJogada(this, m);
    }
    
    public Movimento realizarMovimento(){
        String posicao = ig.lerEntrada("Jogador" + nome + "=> ");
        Movimento m = new Movimento(posicao);
        return m;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the simbolo
     */
    public char getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the tabuleiro
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    /**
     * @param tabuleiro the tabuleiro to set
     */
    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
}
