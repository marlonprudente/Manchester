/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author marlon
 */
public class Test {

    public static void main(String[] args) {
        Integer binario, inteiro;
        binario = Integer.toBinaryString(100);
        String numeroEmTexto = Integer.toString(binario);
        
        int[] array = new int[numeroEmTexto.length()];
        for (int i = 0; i < numeroEmTexto.length(); i++) {
            array[i] = Character.getNumericValue(numeroEmTexto.charAt(i));
            System.out.println("Posicao " + i + ": " + array[i]);
        }
        
        System.out.println("Nro 100: ");

    }
}
