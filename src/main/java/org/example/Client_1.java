package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        // Thread pentru a asculta mesajele de la server (de la alti clienti)
        new Thread(() -> {
            try {
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                }
            } catch (IOException e) {
                System.out.println("Deconectat de la server.");
            }
        }).start();

        // Citim de la tastatura si trimitem la server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client 1 conectat. Scrie un mesaj:");
        
        // Trimitem un prim mesaj automat pentru a pastra comportamentul intial
        out.println("Salut! (de la Client 1)");

        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            out.println(message);
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

        socket.close();
    }
}
