package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public static void execute(String languageTag, ResourceBundle messages) {
        Locale locale;
        if (languageTag == null || languageTag.isEmpty()) {
            locale = Locale.getDefault();
        } else {
            locale = Locale.forLanguageTag(languageTag);
        }

        ResourceBundle.clearCache();
        ResourceBundle infoMessages = ResourceBundle.getBundle("res.Messages", locale);

        System.out.println(infoMessages.getString("info").replace("{0}", locale.getDisplayName()));
        System.out.println("Country: " + locale.getDisplayCountry() + " (" + locale.getDisplayCountry(locale) + ")");
        System.out.println("Language: " + locale.getDisplayLanguage() + " (" + locale.getDisplayLanguage(locale) + ")");
        System.out.println("Currency: " + Currency.getInstance(locale).getCurrencyCode() + " ("
                + Currency.getInstance(locale).getDisplayName(locale) + ")");

        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] weekdays = symbols.getWeekdays();
        System.out.print("Week Days: ");
        for (int i = 2; i < weekdays.length; i++) {
            System.out.print(weekdays[i]);
            if (i < weekdays.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        String[] months = symbols.getMonths();
        System.out.print("Months: ");
        for (int i = 0; i < months.length; i++) {
            System.out.print(months[i]);
            if (i < months.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", locale);
        System.out.println("Today: " + dateFormat.format(new Date()) + " (" + dateFormat.format(new Date()) + ")");
    }
}
