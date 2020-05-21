package com;

import java.util.Locale;

public class DisplayLocales {
    public static void display() {
        System.out.println("Locales: ");
        Locale locales[] = Locale.getAvailableLocales();
        for(Locale locale : locales) {
            System.out.println(locale.getDisplayCountry() + "\t" + locale.getDisplayLanguage());
        }
    }
}
