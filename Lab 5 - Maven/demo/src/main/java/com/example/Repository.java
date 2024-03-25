package repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

import document.*;
import person.*;
import invalid.*;

public class Repository {

    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) throws InvalidRepository {
        this.directory = directory;
        loadDocuments();
    }

    private void loadDocuments() throws InvalidRepository {
        File masterDirectory = new File(directory);
        if (!masterDirectory.exists() || !masterDirectory.isDirectory()) {
            throw new InvalidRepository(new IOException("Invalid master directory."));
        }

        File[] personDirectories = masterDirectory.listFiles();
        if (personDirectories == null) {
            throw new InvalidRepository(new IOException("Error while listing person directories."));
        }

        for (File personDir : personDirectories) {
            if (personDir.isDirectory()) {
                List<Document> personDocuments = new ArrayList<>();
                File[] files = personDir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            personDocuments.add(new Document(file.getName(), getFileExtension(file)));
                        }
                    }
                }
                String[] dirNameParts = personDir.getName().split("_");
                if (dirNameParts.length != 2) {
                    throw new InvalidRepository(new IOException("Invalid person directory name."));
                }
                int personId = Integer.parseInt(dirNameParts[1]);
                documents.put(new Person(dirNameParts[0], personId), personDocuments);
            }
        }
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }

    public String getDirectory() {
        return directory;
    }
}
