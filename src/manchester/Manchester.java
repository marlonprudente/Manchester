/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manchester;

/**
 *
 * @author Caroline Sena / Geovana Franco / Marlon Prudente
 */
public class Manchester {
    Integer[] encode(Integer entrada[]){
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
    
    Integer[] decode(Integer entrada[]){
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
