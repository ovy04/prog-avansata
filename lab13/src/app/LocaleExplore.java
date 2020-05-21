package app;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import com.*;

public class LocaleExplore {
    public static void displayMessages(Locale locale) {
        String baseName = "res.Messages";
        Locale local = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
        Scanner keyboard = new Scanner(System.in);
        System.out.println(messages.getString("prompt"));
        String comanda = keyboard.nextLine();
        if(comanda.equals("locales")) {
            System.out.println(messages.getString("locales"));
            DisplayLocales.display();
        }
        else if(comanda.equals("locale.set")) {
            String pattern = messages.getString("locale.set");
            System.out.println("Specificati limba si tara pe care doriti sa o setati");
            String loc = keyboard.nextLine();
            String tara = keyboard.nextLine();
            local = new Locale(loc, tara);
            SetLocale.set(local);
            Object[] argument = {local};
            String localeSet = new MessageFormat(pattern).format(argument);
            System.out.println(localeSet);
        }
        else if(comanda.equals("info")) {
            String pattern = messages.getString("info");
            Object[] argument = {local};
            String info = new MessageFormat(pattern).format(argument);
            System.out.println(info);
            Info.displayInfo(local);
        }
        else {
            System.out.println(messages.getString("invalid"));
        }
    }
    public static void main(String[] args) {
        while (true)
            displayMessages(Locale.forLanguageTag("ro"));
    }
}
