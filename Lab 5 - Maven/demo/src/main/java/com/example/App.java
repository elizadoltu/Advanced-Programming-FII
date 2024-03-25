package com.example;

import repository.*;

import java.io.IOException;

import document.*;
import person.*;
import invalid.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String masterDirectoryPath = "/path/to/master/directory"; // Replace with your master directory path

        try {
            Repository repository = new Repository(masterDirectoryPath);
            RepositoryService repositoryService = new RepositoryService();

            // Test exporting repository
            String exportFilePath = "/path/to/export/repository.json"; // Replace with your export file path
            repositoryService.export(repository, exportFilePath);
            System.out.println("Repository exported successfully.");

            // Test reading repository
            Repository importedRepository = repositoryService.read(exportFilePath);
            System.out.println("Repository imported successfully.");

            // Display imported repository contents
            displayRepositoryContents(importedRepository);

        } catch (InvalidRepository | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void displayRepositoryContents(Repository repository) {
        System.out.println("Repository Directory: " + repository.getDirectory());
        System.out.println("Repository Contents:");
        for (Person person : repository.getDocuments().keySet()) {
            System.out.println("Person: " + person.name() + ", ID: " + person.id());
            System.out.println("Documents:");
            for (Document document : repository.getDocuments().get(person)) {
                System.out.println("  Name: " + document.name() + ", Format: " + document.format());
            }
            System.out.println();
        }
    }
}
