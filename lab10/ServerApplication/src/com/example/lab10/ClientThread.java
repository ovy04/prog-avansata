package com.example.lab10;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    public ClientThread(Socket socket) {
        this.socket=socket;
    }
    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String comanda = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns;
                if (comanda.compareTo("stop") != 0) {
                    raspuns = "Serverul a primit comanda " + comanda;
                    out.println(raspuns);
                    out.flush();
                } else {
                    raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    System.exit(0);
                }
            }
        } catch(IOException e) {
            System.err.println("Eroare in client thread " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
