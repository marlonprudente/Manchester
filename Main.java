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
public class Main {
    public static void main(String[] args) {
        manchester m = new manchester();
        Integer entrada[] = {1,0,1,0,0};
        Integer saida[];
        Integer saida2[];
        saida = m.encode(entrada);
        for(int i = 0; i<saida.length ; i++){
            System.out.print(saida[i]);
        }
        System.out.println("");
        saida2 = m.decode(saida);
        for(int i = 0; i<saida2.length ; i++){
            System.out.print(saida2[i]);
        }
        System.out.println("");
    }
}
