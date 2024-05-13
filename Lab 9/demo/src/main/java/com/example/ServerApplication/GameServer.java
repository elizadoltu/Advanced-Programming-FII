package com.example.ServerApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.example.ServerApplication.ClientThread;
import com.example.ServerApplication.CommandHandler;
import com.example.ServerApplication.Game;

public class GameServer {
    private ServerSocket serverSocket;
    private int port;
    private Map<String, Game> games;
    private CommandHandler commandHandler;
    private ClientThread clientThread;

    public GameServer(int port) {
        this.port = port;
        this.games = new HashMap<>();
        this.commandHandler = new CommandHandler(this);
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);

                ClientThread clientThread = new ClientThread(socket, this);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleCommand(ClientThread clientThread, String command) {
        commandHandler.handleCommand(command);
    }

    public void sendResponseToClient(String response) {
        clientThread.sendResponse(response);
    }

    public void createGame(String gameId, int timeLimit) {
        if (!games.containsKey(gameId)) {
            // Create a new game
            Game game = new Game(gameId, timeLimit);
            games.put(gameId, game);

            sendResponseToClient("Game created successfully. ID: " + gameId);
        } else {
            sendResponseToClient("Game ID already exists. Please choose a different ID.");
        }
    }

    public void joinGame(String gameId, String playerId, String username) {
        Game game = games.get(gameId);

        if (game != null) {
            if (!game.isActive()) {
                // Add player to the game
                Player player = new Player(playerId, username, game.getTimeLimit());
                game.addPlayer(player);

                sendResponseToClient("Successfully joined game: " + gameId);
            } else {
                sendResponseToClient("Game is already in progress. Cannot join.");
            }
        } else {
            sendResponseToClient("Game ID does not exist.");
        }
    }

    public static void main(String[] args) {
        int port = 1234; // Change this to the desired port number
        GameServer server = new GameServer(port);
        server.start();
    }
}
