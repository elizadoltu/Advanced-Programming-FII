import java.util.List;

public class Player implements Runnable {
    private final String name;
    private final Game game;
    private boolean running;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        this.running = true;
    }

    public void run() {
        while (running) {
            synchronized (game) {
                if (game.getCurrentPlayer() == this) {
                    if (game.isBagEmpty()) {
                        break; 
                    }
                    List<Tile> extractedTiles = game.extractTiles(1);
                    System.out.println(name + " extracted: " + extractedTiles);
                    game.nextPlayerTurn();
                } else {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
}
