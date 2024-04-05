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
public class Tabuleiro {

    private int NumJogadas;
    private char matriz[][];
    private Interface ig;

    public Tabuleiro(){
        matriz = new char[Constantes.TAMANHO_TABULEIRO][Constantes.TAMANHO_TABULEIRO];
         ig = new Interface();
         limpar();
    }
    
    
    public void limpar() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //i são linhas e j são colunas
                matriz[i][j] = ' ';
            }
        }
    }

    public void escrever() {
        ig.pularLinha();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                ig.imprimirTextoSemQuebra(String.valueOf(matriz[i][j]));
                if (j < matriz.length - 1) {
                    ig.imprimirTextoSemQuebra("|");
                }
            }
            ig.pularLinha();
            if (i < matriz.length - 1) {
                ig.imprimirTextoSemQuebra("------");
            }
            ig.pularLinha();
        }
    }

    public boolean estaCheio() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(matriz[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean marcarJogada(Jogador jog, Movimento mov) {
        int i = mov.getI();
        int j = mov.getJ();
        
        matriz[i][j] = jog.getSimbolo();
        return checarLinhas(jog) || checarColunas(jog) || checarDiagonal1(jog) || checarDiagonal2(jog);
    }
    
    public boolean checarLinha(int i, Jogador jog){
        char simbolo = jog.getSimbolo();
        for(int j=0; j<Constantes.TAMANHO_TABULEIRO ;j++){
            if(matriz[i][j] != simbolo){
                return false;
            }
        }
        return true;
    }
    
    public boolean checarLinhas(Jogador jog){
        for(int i = 0; i < Constantes.TAMANHO_TABULEIRO; i++){
            if(checarLinha(i, jog)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checarColuna(int j, Jogador jog){
        char simbolo = jog.getSimbolo();
        for(int i=0; i<Constantes.TAMANHO_TABULEIRO ;i++){
            if(matriz[i][j] != simbolo){
                return false;
            }
        }
        return true;
    }
    
    public boolean checarColunas(Jogador jog){
        for(int j = 0; j < Constantes.TAMANHO_TABULEIRO; j++){
            if(checarColuna(j, jog)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checarDiagonal1(Jogador jog){
        char simbolo = jog.getSimbolo();
        for(int i = 0; i < Constantes.TAMANHO_TABULEIRO; i++){
            if(matriz[i][i] != simbolo){
                return false;
            }
        }
        return true;
    }
    
    public boolean checarDiagonal2(Jogador jog){
        char simbolo = jog.getSimbolo();
        int ultimalinha = Constantes.TAMANHO_TABULEIRO - 1;
        for(int i = ultimalinha, j = 0; i >= 0; i--, j++){
            if(matriz[i][j] != simbolo){
                return false;
            }
        }
        return true;
    }
    
    public int getNumJogadas() {
        return NumJogadas;
    }

    public void setNumJogadas(int NumJogadas) {
        this.NumJogadas = NumJogadas;
    }

    /**
     * @return the matriz
     */
    public char[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }
}
