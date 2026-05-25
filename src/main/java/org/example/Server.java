package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    // Lista pentru a pastra legatura cu toti clientii conectati
    private static List<PrintWriter> clientWriters = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        int port = 5001;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept(); // asteapta un client
            System.out.println("Client connected");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            clientWriters.add(out);

            // Cream un thread separat pentru fiecare client
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream())
                    );

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Client says: " + message);
                        
                        // Trimitem mesajul catre TOTI ceilalti clienti conectati
                        for (PrintWriter writer : clientWriters) {
                            if (writer != out) { // Nu ii trimitem inapoi tot lui
                                writer.println("Alt client: " + message);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Client deconectat.");
                } finally {
                    clientWriters.remove(out);
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

