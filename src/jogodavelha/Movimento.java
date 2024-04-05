
package jogodavelha;

public class Movimento {
    private int i;
    private int j;
    
    public Movimento(String ms) throws execaoMovimentoInvalido{
        String [] pedacos = ms.split(",");
        
        this.i = Integer.parseInt(pedacos[0]);
        this.j = Integer.parseInt(pedacos[1]);
                try {
            String[] fragmentado = ms.split(",");
            this.i = Integer.parseInt(fragmentado[0]);
            this.i = Integer.parseInt(fragmentado[1]);
        } catch(Exception e){
            throw new execaoMovimentoInvalido("isso fere os direitos humanos");
        }

    }
    

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * @return the j
     */
    public int getJ() {
        return j;
    }

    /**
     * @param j the j to set
     */
    public void setJ(int j) {
        this.j = j;
    }
    
}
