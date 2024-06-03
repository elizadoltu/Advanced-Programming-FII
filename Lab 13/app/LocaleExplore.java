package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale defaultLocale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages", defaultLocale);

        while (true) {
            System.out.print(messages.getString("prompt"));
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("locales")) {
                DisplayLocales.execute(messages);
            } else if (command.startsWith("setlocale ")) {
                String languageTag = command.substring(10).trim();
                SetLocale.execute(languageTag, messages);
                messages = ResourceBundle.getBundle("res.Messages", Locale.getDefault());
            } else if (command.startsWith("info")) {
                String[] parts = command.split(" ");
                if (parts.length == 1) {
                    Info.execute(null, messages);
                } else {
                    Info.execute(parts[1].trim(), messages);
                }
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
    }
}