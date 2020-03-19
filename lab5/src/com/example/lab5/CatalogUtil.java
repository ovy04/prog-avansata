package com.example.lab5;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatalogUtil {
    //save folosind serializare
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getCale()))) {
            oos.writeObject(catalog);
        }
    }
    //tentativa de save in fisier plaintext
    public static void savePlain(Catalog catalog) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(catalog.getCale()), "UTF-8"))) {
            writer.write(catalog.getNume());
            writer.write("\n");
            writer.write(catalog.getCale());
            for(Document c : catalog.getDocumente()) {
                writer.write(c.getId() + " " + c.getNume() + "\n");
            }
        }
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        if(doc.getLocatie().substring(0,4).equals("http")) {
            try {
                desktop.browse(new URI(doc.getLocatie()));
            } catch(URISyntaxException | IOException e) {
                System.err.println(e);
            }
        }
        else {
            try {
                desktop.open(new File(doc.getLocatie()));
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    //load din fisier
    public static Catalog load(String cale) throws InvalidCatalogException {
        try(var ois = new ObjectInputStream(new FileInputStream(cale))) {
            return (Catalog)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
        return null;
    }
    //tentativa neterminata de load din plaintext
    public static Catalog loadPlain(String cale) throws InvalidCatalogException {
        Catalog catalog = new Catalog();
        try(BufferedReader br = Files.newBufferedReader(Paths.get(cale))) {
            String line;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
