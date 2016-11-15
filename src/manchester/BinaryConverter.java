/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manchester;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author marlon
 */
public class BinaryConverter {

    public String BinaryToText(Integer[] binario) {
        int letras = (binario.length / 8);
        char c[] = new char[binario.length];
        String nome;
        int j = 0, k = 0, l = 1, m = 0;
        int op = 0;
        //System.out.println("BL: " + binario.length);

        while (k != binario.length) {

            for (j = 0; j < 8; j++) {
                op += binario[k] * l;
                //System.out.println(binario[k] + "*" + l + "=" + op);
                l = 2 * l;
                k++;
            }

            //System.out.println("OP = " + op);
            c[m] = (char) op;
            m++;
            op = 0;
            l = 1;

        }
        //aqui estou invertendo a ordem da string
        int tam = c.length;
        char[] aux = new char[c.length];
        for (int i = 0; i < aux.length; i++) {
            tam--;
            aux[i] = c[tam];
        }
        //Aqui eu estou copiando so a parte que interessa do vetor
        c = Arrays.copyOfRange(aux, binario.length - letras, binario.length);
        
        //aqui estou transformando o vetor de char em uma string
        nome = String.valueOf(c);
        
        return nome;
    }

    public Integer[] textToBinary(String texto) {
        int op = texto.length() * 8; //numero de characteres * numero de bits
        //Integer bin;//Aqui é necessário definir o tamanho para 8 caracteres (ainda não fiz)
        Integer[] array = new Integer[op];
        int j = 0, k = 0;

        for (char c : texto.toCharArray()) {
            //Agora e preciso dividir cada caractere em uma posicao do vetor para o manchester
            //System.out.println("Binário Correto" + StringUtils.leftPad(Integer.toBinaryString((c)), 8, "0"));
           // bin = Integer.parseInt(StringUtils.leftPad(Integer.toBinaryString((c)), 8, "0"));            
            //System.out.println("BIN = " + bin);
            //Aqui estou transformando em um vetorzão com todos os 0's e 1's
            while (j != 8) {
                array[k] = Character.getNumericValue(StringUtils.leftPad(Integer.toBinaryString((c)), 8, "0").charAt(j));
                j++;
                k++;
            }
            j = 0;

        }
        //aqui estou invertendo a ordem da string
        int tam = array.length;
        Integer[] aux = new Integer[op];
        for (int i = 0; i < aux.length; i++) {
            tam--;
            aux[i] = array[tam];
        }
        array = aux;
        return array;
    }

}
