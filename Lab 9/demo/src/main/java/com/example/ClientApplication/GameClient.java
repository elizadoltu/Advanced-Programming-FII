package com.example.ClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader userInputReader;

    public GameClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
            userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to the server.");
        } catch (IOException e) {
            System.err.println("Error: Failed to connect to the server");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void sendCommand(String command) {
        out.println(command);
    }

    public void close() {
        try {
            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startClient() {
        System.out.println("Welcome to the Game Client!");
        System.out.println("Enter one of the following commands:");
        System.out.println("- create <gameId> <timeLimit>: Create a new game with the specified ID and time limit.");
        System.out.println("- join <gameId>: Join an existing game with the specified ID.");
        System.out.println("- submit <move>: Submit a move in the current game.");
        System.out.println("- exit: Exit the client.");

        System.out.println("\nEnter commands:");

        try {
            String input;
            while ((input = userInputReader.readLine()) != null) {
                if (input.equalsIgnoreCase("exit")) {
                    close();
                    break;
                } else {
                    sendCommand(input);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user input.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        GameClient client = new GameClient(serverAddress, serverPort);
        client.startClient();
    }
}