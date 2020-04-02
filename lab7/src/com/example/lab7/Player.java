package com.example.lab7;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    String nume;
    Game joc;
    List<Token> lista_tokeni= new ArrayList<>();

    public Player(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Game getJoc() {
        return joc;
    }

    public void setJoc(Game joc) {
        this.joc = joc;
    }

    public void adaugaToken(Token token) {
        lista_tokeni.add(token);
    }

    public List<Token> getTokeni() {
        return lista_tokeni;
    }

    private void selecteazaToken() {
        joc.extrageToken(this);
    }

    @Override
    public void run() {
        while(!joc.getGameover()) {
            selecteazaToken();
            //System.out.println("juc " + joc.getGameover());
            //System.out.println(joc.getTabla().getTokens().size());
        }
    }
}
