/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

/**
 *
 * @author 04088452011
 */
public class execaoMovimentoInvalido extends Exception {

    /**
     * Creates a new instance of <code>execaoMovimentoInvalido</code> without
     * detail message.
     */
    public execaoMovimentoInvalido() {
    }

    /**
     * Constructs an instance of <code>execaoMovimentoInvalido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public execaoMovimentoInvalido(String msg) {
        super(msg);
    }
}
