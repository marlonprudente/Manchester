/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import manchester.BinaryConverter;
import manchester.Manchester;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 *
 */
public class Servidor {

    /**
     * Método principal da Classe Servidor Usado para Iniciar uma conexão com o
     * cliente Limitado para somente uma conexão simultânea
     */
    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket SocketServidor = new ServerSocket(12345);
        /**
         * Variaveis para a decodificador Manchester*
         */
        Manchester m = new Manchester();
        Integer array[], decriptografado[];
        BinaryConverter bc = new BinaryConverter();
        /*==============================*/

        System.out.println("Porta 12345 aberta!");

        while (true) {
            //Aqui a conexão é feita, o servidor recebe um cliente somente, e se obtiver sucesso, mostra a mensagem de conexão
            Socket connectionSocketCliente = SocketServidor.accept();
            System.out.println("Nova conexão com o cliente: " + connectionSocketCliente.getInetAddress().getHostAddress());
            //Aqui o servidor sempre estará esperando dados do cliente, e exibe o dado na tela
            Scanner s = new Scanner(connectionSocketCliente.getInputStream());
            //Loop Principal, onde o Servidor estará sempre esperando envios do Cliente.
            while (s.hasNextLine()) {
                array = bc.textToBinary(s.nextLine());
                //Aqui é possivel ver o texto criptografado pelo Manchester
                System.out.println("Criptografado: " + bc.BinaryToText(array));
                for (int i : array) {
                    System.out.print(array[i]);
                }
                decriptografado = m.decode(array);
                //Aqui é possivel ver o resultado após a descriptografia do Manchester
                System.out.println("\nDecriptografado: " + bc.BinaryToText(decriptografado));
                for (int i : decriptografado) {
                    System.out.print(decriptografado[i]);
                }
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
