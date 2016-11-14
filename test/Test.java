/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import manchester.*;

/**
 *
 * @author marlon
 */
public class Test {

    public static void main(String[] args) {
        //BinaryConverter binconvert = null;
        String binario, textoEmNumero;
        binario = Integer.toBinaryString(100);
        Integer ent[], bin[] = null;
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
        for (char c : textoEmNumero.toCharArray()) {
            System.out.println(c + " = " + Integer.toBinaryString((c)));
            //Aqui é possivel ver o numero binario gerado pela string
            System.out.println("Inteiro: " + Integer.parseInt(Integer.toBinaryString((c))));
            //Agora e preciso dividir cada caractere em uma posicao do vetor para o manchester

        }

    }
}
