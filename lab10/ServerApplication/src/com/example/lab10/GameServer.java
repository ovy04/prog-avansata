package com.example.lab10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8000;
    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("Asteptam o comanda...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch(IOException e) {
            System.err.println("Eroare in server " + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}
