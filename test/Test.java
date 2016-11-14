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
        Integer ent[], bin;
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
        int op = textoEmNumero.length() * 7;
        System.out.println("=>" + op);
        Integer[] array2 = new Integer[op];
        int j = 0, k = 0;
        for (char c : textoEmNumero.toCharArray()) {
            //System.out.println(c + " = " + Integer.toBinaryString((c)));
            //Aqui é possivel ver o numero binario gerado pela string
            // System.out.println("Inteiro: " + Integer.parseInt(Integer.toBinaryString((c))));

            //Agora e preciso dividir cada caractere em uma posicao do vetor para o manchester
            bin = Integer.parseInt(Integer.toBinaryString((c)));
            
            //Aqui estou transformando em um vetorzão com todos os caracteres
            while (j != 7) {
                array2[k] = Character.getNumericValue(bin.toString().charAt(j));
                j++;
                k++;
            }
            j = 0;

        }

        System.out.println("Antes do Manchester: ");
        for (int i = 0; i < op; i++) {
            System.out.print(array2[i] + " - ");
        }
        System.out.println("");
        //Utilizando o Manchester
        ent = m.encode(array2);
        //testando o Manchester
        System.out.println("Depois do Manchester: ");
        for (int i = 0; i < op; i++) {
            System.out.print(ent[i] + " - ");
        }
        System.out.println("");

    }
}
