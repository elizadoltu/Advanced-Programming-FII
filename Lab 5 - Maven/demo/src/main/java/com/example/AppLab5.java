package com.example;

import com.example.document.*;
import com.example.invalid.*;
import com.example.person.*;
import com.example.repository.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class AppLab5 {
    public static void main(String[] args) {
        String masterDirectoryPath = "C:/Users/Admin/Desktop/Proiecte/Facultate/Advanced Programming/Advanced-Programming-FII/Doltu_1234"; // Replace with your master directory path

        try {
            Repository repository = new Repository(masterDirectoryPath);

            // Display the directory and its contents
            System.out.println("Master Directory: " + repository.getDirectory());
            System.out.println("Repository Contents:");
            for (Person person : repository.getDocuments().keySet()) {
                System.out.println("Person: " + person.name() + ", ID: " + person.id());
                System.out.println("Documents:");
                for (Document document : repository.getDocuments().get(person)) {
                    System.out.println("  Name: " + document.name() + ", Format: " + document.format());
                }
                System.out.println();
            }

        } catch (InvalidRepository e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
