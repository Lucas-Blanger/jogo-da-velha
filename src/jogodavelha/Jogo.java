
package jogodavelha;


public class Jogo {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Jogador[] jogadores = new Jogador[Constantes.SIMBOLOS_JOGADORES.length];
    private Interface ig = new Interface();
    private int indiceJogadorAtual = -1;
    private boolean sequencia_encontrada = false;
    
    public Jogador criarJogador(int indice){
        String nome = ig.lerEntrada("Jogador " + (indice + 1) + " digite seu nome: ");
        char simbolo = Constantes.SIMBOLOS_JOGADORES[indice];
            Jogador jog = new Jogador(nome, this.tabuleiro, simbolo);
            ig.imprimirTexto("O jogador " + nome + " vai usar o símbolo " + simbolo);
            return jog;
    }
    
    public void jogar(){
        //Interface ig = new Interface();
        ig.imprimirTituloJogo();
        /*tabuleiro.limpar();
        tabuleiro.escrever();*/
        for(int i = 0; i < jogadores.length; i++){
            Jogador jogador = criarJogador(i);
            jogadores[i] = jogador;
        }
        Jogador jogadorAtual = proximoJogador();
        
        Jogador vencedor = null;
        boolean jogoTerminado = false;
        while(!jogoTerminado){
            tabuleiro.escrever();
             try {
                sequencia_encontrada = jogadorAtual.realizarJogada();
            } catch (execaoMovimentoInvalido e) {
                ig.imprimirTexto("ERRO: " + e.getMessage());
                continue;
            }
             
            boolean sequenciaEncontrada = jogadorAtual.realizarJogada();
         
            if(sequenciaEncontrada){
                jogoTerminado = true;
                vencedor = jogadorAtual;
            }else{
                if(tabuleiro.estaCheio()){
                    jogoTerminado = true;
                }
            }
            jogadorAtual = proximoJogador();
        }
        tabuleiro.escrever();
        if(vencedor == null){
            ig.imprimirTexto("O jogo terminou empatado!");
        }else{
            ig.imprimirTexto("O jogador "+vencedor.getNome() + "venceu o jogo!");
        }
        
        ig.imprimirTexto("Fim do jogo");
    }
    
    private Jogador proximoJogador(){
        indiceJogadorAtual++;
        if(indiceJogadorAtual >= jogadores.length){
            indiceJogadorAtual = 0;
        }
        return jogadores[indiceJogadorAtual];
    }
    
}
