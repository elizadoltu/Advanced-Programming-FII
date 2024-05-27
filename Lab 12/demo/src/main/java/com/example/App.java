package com.example;

import java.io.File;

public class App {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java -cp out com.example.Main <path_to_input_file_or_directory> <package_name>");
            return;
        }

        try {
            File inputFile = new File(args[0]);
            String packageName = args[1];
            System.out.println("Starting exploration and analysis...");
            System.out.println("Input file or directory: " + inputFile.getAbsolutePath());
            System.out.println("Package name: " + packageName);
            DirectoryExplore.exploreAndAnalyze(inputFile, packageName);
            TestStatics.printStatistics();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
