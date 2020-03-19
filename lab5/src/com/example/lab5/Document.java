package com.example.lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String nume;
    private String locatie;
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String nume, String locatie) {
        this.id = id;
        this.nume = nume;
        this.locatie = locatie;
    }

    public Document() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public void addTag(String cheie, Object obj) {
        tags.put(cheie, obj);
    }
}
