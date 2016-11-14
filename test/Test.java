/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */

import manchester.*;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Test {

    public static void main(String[] args) {
        //BinaryConverter binconvert = null;
        String binario, textoEmNumero;
        binario = Integer.toBinaryString(100);
        Integer ent[], bin, sai[];
        Manchester m = new Manchester();
        textoEmNumero = "abcd";

        int[] array = new int[binario.length()];
        for (int i = 0; i < binario.length(); i++) {
            array[i] = Character.getNumericValue(binario.charAt(i));
            System.out.println("Posicao " + i + ": " + array[i]);
        }
        //Binario do Nro. 100
        System.out.println("Nro 100: ");
        for (int i = 0; i < binario.length(); i++) {
            System.out.print(array[i]);
        }

        System.out.println("");

        //Characteres da string textoEmNumero para Binário
        System.out.println("abcd em Binario: ");
        Integer[] array2;
        //Coloquei tudo em uma classe que faz a conversão da String em um vetorzão de 0's e 1's
        BinaryConverter bc = new BinaryConverter();
        array2 = bc.textToBinary(textoEmNumero);
        System.out.println("Antes do Manchester: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + "");

        }
        System.out.println("");
        System.out.println("String normal ===>" + bc.BinaryToText(array2));
        //Utilizando o Manchester
        ent = m.encode(array2);
        //testando o Manchester
        System.out.println("Depois do Manchester: ");
        for (int i = 0; i < ent.length; i++) {
            System.out.print(ent[i] + "");
        }
        System.out.println("");
        System.out.println("String encode===>" + bc.BinaryToText(ent));
        System.out.println("");
        
        sai = m.decode(ent);
        System.out.println("String decode ===>" + bc.BinaryToText(sai));
        //Implementar agora a melhor forma de transformar o vetor de binarios em strings

    }
}
