
package jogodavelha;

import java.util.Scanner;


public class Interface {
    Scanner sc = new Scanner(System.in);
    
    public void imprimirTexto(String texto){
        System.out.println(texto);
    }
    
    public void imprimirTextoSemQuebra(String texto){
        System.out.print(texto);
    }
    
    public void pularLinha(){
        System.out.println();
    }
    
    public void imprimirTituloJogo(){
        imprimirTexto("=================");
        imprimirTexto("| JOGO DA VELHA |");
        imprimirTexto("=================");
        pularLinha();
    }
    
    public String lerEntrada(String texto){
        imprimirTextoSemQuebra(texto + " ");
        String s = sc.next();
        return s;
    }
}
