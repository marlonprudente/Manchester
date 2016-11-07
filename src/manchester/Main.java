/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manchester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Caroline Sena / Geovana Franco / Marlon Prudente
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer ent[], sai[];
        manchester m = new manchester();
        /*Integer entrada[] = {1, 0, 1, 0, 0};
         Integer saida[];
         Integer saida2[];
         saida = m.encode(entrada);
         for (int i = 0; i < saida.length; i++) {
         System.out.print(saida[i]);
         }
         System.out.println("");
         saida2 = m.decode(saida);
         for (int i = 0; i < saida2.length; i++) {
         System.out.print(saida2[i]);
         }
         System.out.println("");
         */
        int escolha = 1;
        while (escolha != 0) {
            System.out.println("Escolha:\n1 - Codificação\n2 - Decodificação\n0 - Sair");
            escolha = Integer.parseInt(in.readLine().toString());
            switch (escolha) {
                case 1:
                    System.out.println("Tamanho do vetor");
                    int x = Integer.parseInt(in.readLine().toString());
                    ent = new Integer[x];
                    System.out.println("Valores:");
                    for (int i = 0; i < x; i++) {
                        int y = Integer.parseInt(in.readLine().toString());
                        while (y != 0 && y != 1) {
                            System.out.println("Permitido 0 e 1 apenas");
                            y = Integer.parseInt(in.readLine().toString());
                        }
                        ent[i] = y;
                    }
                    sai = m.encode(ent);
                    System.out.println("Entrada");
                    for (int i = 0; i < ent.length; i++) {
                        System.out.print(ent[i]);
                    }
                    System.out.println("\nSaida codificada");
                    for (int i = 0; i < sai.length; i++) {
                        System.out.print(sai[i]);
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Tamanho do vetor");
                    x = Integer.parseInt(in.readLine().toString());
                    if (x % 2 != 0) {
                        System.out.println("Precisa ser um tamanho par");
                    } else {
                        ent = new Integer[x];
                        System.out.println("Valores:");
                        for (int i = 0; i < x; i++) {
                            int y = Integer.parseInt(in.readLine().toString());
                            while (y != 0 && y != 1) {
                                System.out.println("Permitido 0 e 1 apenas");
                                y = Integer.parseInt(in.readLine().toString());
                            }
                            ent[i] = y;
                        }
                        sai = m.decode(ent);
                        System.out.println("Saida decodificada");
                        for (int i = 0; i < sai.length; i++) {
                            System.out.print(sai[i]);
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Entrada inválida!");
            }
        }

    }
}
