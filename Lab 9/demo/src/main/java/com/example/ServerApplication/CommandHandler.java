package com.example.ServerApplication;

public class CommandHandler {

    private GameServer gameServer;

    public CommandHandler(GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public void handleCommand(String command) {
        String[] parts = command.split(" ");
        String commandType = parts[0];

        switch (commandType) {
            case "create":
                handleCreateGameCommand(parts);
                break;
            case "join":
                handleJoinGameCommand(parts);
                break;
            default:
                gameServer.sendResponseToClient("Unknown command: " + command);
        }
    }

    private void handleCreateGameCommand(String[] parts) {

        // create <gameId> <timeLimit>
        if (parts.length != 3) {
            gameServer.sendResponseToClient("Invalid command format. Usage: create <gameId> <timeLimit>");
            return;
        }

        String gameId = parts[1];
        int timeLimit = Integer.parseInt(parts[2]);

        gameServer.createGame(gameId, timeLimit);
    }

    private void handleJoinGameCommand(String[] parts) {
        // join <gameId>
        if (parts.length != 2) {
            gameServer.sendResponseToClient("Invalid command format. Usage: join <gameId>");
            return;
        }

        String gameId = parts[1];
        String playerId = "";
        String username = "";

        gameServer.joinGame(gameId, playerId, username);
    }
}
