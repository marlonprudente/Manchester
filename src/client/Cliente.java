/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import manchester.Manchester;

/**
 * @author Marlon Prudente
 * @author Mateus Oliveira
 */
public class Cliente {

    public static void main(String[] args) throws Exception {

        String sentence;
        String modifiedSentence;
        /**
         * Variaveis para o codificador Manchester*
         */
        Manchester m = new Manchester();
        Integer ent[], binario[] = null;
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
               //O comando nextLine le o que foi digitado depois do enter
                saida.println(teclado.nextLine());

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
