package by.bylnova.archive.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 8082);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new Scanner(clientSocket.getInputStream());
                out = new PrintWriter(clientSocket.getOutputStream());

                System.out.println("Вы что-то хотели сказать? Введите это здесь:");
                String word = reader.readLine();
                while (true) {
                    out.println(word);
                    out.flush();
                    if (in.hasNext()) {
                        String inMes = in.nextLine();
                        System.out.println(inMes);
                    }
                    word = reader.readLine();
                }
                /*while (word != null) {
                    out.write(word + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                    System.out.println(serverWord);
                    word = reader.readLine();
                }*/
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.out.println("io exception");
        }
    }
}