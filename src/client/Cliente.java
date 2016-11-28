/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import manchester.BinaryConverter;
import manchester.Manchester;

/**
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 *
 */
public class Cliente {

    /**
     * Método principal da Classe Cliente. Usado para Iniciar uma conexão com o
     * Servidor.
     *
     */
    public static void main(String[] args) throws Exception {

        String sentence;
        String modifiedSentence;
        /**
         * Variaveis para o codificador Manchester*
         */
        Manchester m = new Manchester();
        Integer array[], criptografado[];
        BinaryConverter bc = new BinaryConverter();
        /*==============================*/
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        /*Ip do Servidor e porta*/
        Socket clientSocket = new Socket("127.0.0.1", 12345);
        System.out.println("O cliente se conectou ao servidor!");
        //Aqui esta a variavel que estara lendo o teclado
        Scanner teclado = new Scanner(System.in);
        //Aqui esta a variavel que enviara para o servidor

        PrintStream saida = new PrintStream(clientSocket.getOutputStream());

        while (teclado.hasNextLine()) {
            array = bc.textToBinary(teclado.nextLine());
            System.out.println("Antes de Criptografar: ");
            for (int i : array) {
                System.out.print(array[i]);
            }
            //O comando nextLine le o que foi digitado depois do enter
            criptografado = m.encode(array);
            System.out.println("");
            System.out.println("Depois de Criptografar: ");
            for (int i : criptografado) {
                System.out.print(criptografado[i]);
            }
            saida.println(bc.BinaryToText(criptografado));

        }

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader InFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = InFromServer.readLine();

        System.out.println(modifiedSentence);
        clientSocket.close();
        saida.close();
    }

}
