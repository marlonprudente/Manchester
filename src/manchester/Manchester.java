/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package manchester;

/**
 *
 * @author Geovana Franco
 */
public class Manchester {
    /**
     * Metodo encode é usado para Codificar o vetor de binarios
     * @param entrada (Vetor de Binarios que representa os dados de entrada).
     * @return saida (valor codificado, de tamanho duas vezes maior que a entrada).
     */
    public Integer[] encode(Integer entrada[]){
        Integer saida[]=new Integer[entrada.length*2];
        // System.out.println("tam "+entrada.length);
        int bid = 0,nbid = 0,real = 0, bit = 0, nbit =0;
        
        for (int i = 0; i < entrada.length; i++)
        {
            // Arruma os indices
            bid = i * 2;
            nbid = bid + 1;

            // Pega o dado
            real = entrada[i];

            bit = 0;
            nbit = 0;

            // Se recebe 0, coloca a representação de 0, caso contrario de 1
            if (real == 0){
                bit = 1; // Subtract 48 to work out the real value
                nbit = 0;
            }else{
                bit = 0; // 
                nbit = 1;
            }
            //System.out.println("[encode] " + real + " [" + bit + nbit + "]" );
            saida[bid] = bit;
            saida[nbid] = nbit;
        }

        return saida;
    }
    /**
     * Metodo decode é usado para decodificar o vetor codificado de binarios
     * @param entrada (valor codificado, de tamanho duas vezes maior que o tamanho original)
     * @return saida (Vetor de Binarios que representa os dados originais de entrada)
     */
    
    public  Integer[] decode(Integer entrada[]){
        Integer saida[]= new Integer[entrada.length/2];
        int real = 0;
        if ((entrada.length % 2) != 0)
        {
            System.out.println("O tamanho não é multiplo de 2");
        }

        for (int i = 0; i < (entrada.length / 2); i++)
        {
            // Encontra os indices para usar
            int bid = i * 2;
            int nbid = bid + 1;

            // Pega o dado
            int bit = entrada[bid];
            int nbit = entrada[nbid];
            //01 - 1
            //10 - 0
            // Coloca o dado dentro de uma variável
            if(bit == 0 && nbit == 1){
                real = 1;
            }else if(bit == 1 && nbit == 0)
                real = 0;
            
            //System.out.println("[decode] bit: " + bit + nbit + " [" + real + "]");
            
            saida[i] = real;
        }
        
        return saida;
    }
    
}
