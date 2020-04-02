package com.example.lab7;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token> tokens = new ArrayList<>();

    public Board(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Board() {
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void addToken(Token token) {
        this.tokens.add(token);
    }

    public void removeToken(Token token) {
        tokens.remove(token);
    }
}
