package com.example.lab7;

import java.util.Random;

public class Game {
    private Board tabla;
    private Player jucator1, jucator2;
    private boolean gameover;

    public Game(Board tabla, Player jucator1, Player jucator2) {
        this.tabla = tabla;
        this.jucator1 = jucator1;
        this.jucator2 = jucator2;
        this.gameover=false;
        jucator1.setJoc(this);
        jucator2.setJoc(this);
    }

    public Board getTabla() {
        return tabla;
    }

    public void setTabla(Board tabla) {
        this.tabla = tabla;
    }

    public Player getJucator1() {
        return jucator1;
    }

    public void setJucator1(Player jucator1) {
        this.jucator1 = jucator1;
    }

    public Player getJucator2() {
        return jucator2;
    }

    public void setJucator2(Player jucator2) {
        this.jucator2 = jucator2;
    }

    private void setGameover(boolean b) {
        gameover=b;
    }

    public boolean getGameover() {
        return gameover;
    }

    public void removeToken(Token t) {
        tabla.removeToken(t);
    }

    public synchronized void extrageToken(Player player) {
        if(tabla.getTokens().size()==0) {
            setGameover(true);
            //System.out.println("game " + gameover);
        }
        else {
            Random r = new Random();
            int index = (int) (Math.random() * tabla.getTokens().size());
            Token tok = new Token(tabla.getTokens().get(index).getNumber());
            if (tok.getNumber() == 0)
                tok.setBlank();
            player.adaugaToken(tok);
            tabla.getTokens().remove(tok);
            System.out.println(tabla.getTokens());
            System.out.println("Jucatorul " + player.getNume() + " extrage  " + tok.toString());
        }
    }



    public void startJoc() {
        Thread t1 = new Thread(jucator1);
        t1.start();
        Thread t2 = new Thread(jucator2);
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
