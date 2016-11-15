/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Marlon Prudente
 * @author Mateus Oliveira
 */
public class Servidor {

    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket SocketServidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");
        
        
        while (true) {
            //Aqui a conexão é feita, o servidor recebe um cliente somente, e se obtiver sucesso, mostra a mensagem de conexão
            Socket connectionSocketCliente = SocketServidor.accept();
            System.out.println("Nova conexão com o cliente: " + connectionSocketCliente.getInetAddress().getHostAddress());
            //Aqui o servidor sempre estará esperando dados do cliente, e exibe o dado na tela
            Scanner s = new Scanner(connectionSocketCliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            s.close();
            //S é a variavel que esta recebendo strings do cliente, deve ser encerrada sempre que a conexao encerrar
            
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocketCliente.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocketCliente.getOutputStream());

            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase();
            outToClient.writeBytes(capitalizedSentence);

        }
    }
}
