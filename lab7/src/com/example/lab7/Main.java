package com.example.lab7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Token> tokeni = new ArrayList<>();
        Player jucator1 = new Player("jucator1");
        Player jucator2 = new Player("jucator2");
        Board tabla = new Board(tokeni);
        int i=0, n=10;
        for(i=0;i<=n;i++) {
            Token tok = new Token(i);
            if (i==0)
                tok.setBlank();
            tabla.addToken(tok);
        }
        Game joc = new Game(tabla, jucator1, jucator2);
        joc.startJoc();
        System.out.println("Tokeni juc1: " +jucator1.getTokeni());
        System.out.println("Tokeni juc2: " +jucator2.getTokeni());
        //System.out.println(tabla.getTokens());
    }
}
