package by.bylnova.archive.server.socketLayer;

import by.bylnova.archive.server.controller.Controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ArchiveServer {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static Controller controller = Controller.getInstance();

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(8082);
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String request = in.readLine();
                    String response;
                    while (request != null) {
                        System.out.println(request);

                        response = controller.executeTask(request);

                        out.write(response);
                        out.flush();
                        request = in.readLine();
                    }

                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
