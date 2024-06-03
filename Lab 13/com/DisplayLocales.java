package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static void execute(ResourceBundle message) {
        Locale [] locales = Locale.getAvailableLocales();
        System.out.println(message.getString("locales"));
        for (Locale locale : locales) {
            System.out.println(locale.getDisplayName());
        }
    }
}
