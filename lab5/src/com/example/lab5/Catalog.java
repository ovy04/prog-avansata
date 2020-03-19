package com.example.lab5;

import javax.print.Doc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String nume;
    private String cale;
    private List<Document> documente = new ArrayList<>();
    public void add(Document doc) {
        documente.add(doc);
    }
    public Document findById(String id) {
        for(Document d : documente) {
            if(d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public Catalog(String nume, String cale) {
        this.nume = nume;
        this.cale = cale;
    }

    public Catalog() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCale() {
        return cale;
    }

    public void setCale(String cale) {
        this.cale = cale;
    }

    public List<Document> getDocumente() {
        return documente;
    }
}
