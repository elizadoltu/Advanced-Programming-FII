package com.example.ServerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private GameServer gameServer;
    private BufferedReader in;
    private PrintWriter out;

    public ClientThread(Socket socket, GameServer gameServer) {
        this.socket = socket;
        this.gameServer = gameServer;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String command;
            while ((command = in.readLine()) != null) {
                gameServer.handleCommand(this, command);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendResponse(String response) {
        out.println(response);
    }
}
