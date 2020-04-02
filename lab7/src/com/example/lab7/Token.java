package com.example.lab7;

import java.util.Objects;

public class Token {
    private int n;
    private boolean blank;

    public Token(int n) {
        this.n = n;
        blank = false;
    }

    public void getToken() {
        if (blank)
            getBlank();
        else
            getNumber();
    }

    public int getNumber() {
        return n;
    }

    public void setBlank() {
        blank = true;
    }

    public String getBlank() {
        return "blank";
    }

    public void setToken(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        if (blank)
            return "Tokenul n= " + n + " blank";
        else
            return "Tokenul n=" + n;
    }

    @Override
    public boolean equals(Object o) {
        Token token = (Token) o;
        return n == token.n;
    }
}
