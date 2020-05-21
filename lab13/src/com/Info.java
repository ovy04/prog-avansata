package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public static void displayInfo(Locale locale) {
        System.out.println("Country: " + locale.getDisplayCountry() + " (" + locale.getDisplayCountry(locale)+ ")");
        System.out.println("Language: " + locale.getDisplayLanguage() + " (" + locale.getDisplayLanguage(locale) + ")");
        System.out.println("Currency: " + Currency.getInstance(locale) + " (" + Currency.getInstance(locale).getDisplayName() + ")");
        DateFormatSymbols simbol = new DateFormatSymbols(locale);
        String[] zile = simbol.getWeekdays();
        StringBuilder s = new StringBuilder();
        //primul element din array e sirul vid, iar al doilea element este duminica asa ca incepem de la al 3-lea
        for(int i = 2; i <= 7; i++) {
            s.append(zile[i]);
            s.append(", ");
        }
        s.append(zile[1]);
        System.out.println("Week days: " + s.toString());
        simbol = new DateFormatSymbols(locale);
        String[] luni = simbol.getMonths();
        s = new StringBuilder();
        for(int i=0; i<=12; i++) {
            s.append(luni[i]);
            s.append(" ");
        }
        System.out.println("Months: " + s.toString());
        LocalDateTime azi = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        DateTimeFormatter formatterRO = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale);
        System.out.println("Today: " + azi.format(formatter) + " (" + azi.format(formatterRO) + ")");
    }
}
