package com.example.gameclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8000;
        try {
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner tastatura = new Scanner(System.in);
            System.out.println("Introduceti o comanda ");
            String comanda = tastatura.nextLine();
            String raspuns;
            while (true) {
                out.println(comanda);
                raspuns = in.readLine();
                System.out.println(raspuns);
                if(comanda.compareTo("exit")==0 || comanda.compareTo("stop")==0)
                    break;
                comanda = tastatura.nextLine();
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening " + e);
        }
    }
}
