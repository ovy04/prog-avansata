package com.example.lab5;

import javax.print.Doc;
import java.io.IOException;

public class Lab5 {
    public static void main(String[] args) {
        Lab5 app = new Lab5();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("d:/Java/catalog.ser");
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);
        } catch (InvalidCatalogException e) {
            System.err.println("Catalog invalid");
        }
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "d:/Java/catalog.ser");
        Document doc=new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            System.err.println("IO error");
        }
    }
}
