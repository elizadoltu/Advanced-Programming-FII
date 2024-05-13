package com.example.ClientApplication;

import java.io.*;
import java.net.*;

public class GameClient {

    private Socket socket;
    private PrintWriter out;

    public GameClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendCommand(String command) {
        out.println(command);
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        GameClient client = new GameClient(serverAddress, serverPort);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            String input;
            while ((input = userInput.readLine()) != null) {
                if (input.equals("exit")) {
                    client.close();
                    break;
                } else {
                    client.sendCommand(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
