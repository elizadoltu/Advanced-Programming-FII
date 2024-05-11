import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players;
    private final List<Thread> playerThreads;
    private int currentPlayerIndex;

    public Game(int numberOfPlayers, int n) {
        bag = new Bag(n);
        players = new ArrayList<>();
        playerThreads = new ArrayList<>();
        currentPlayerIndex = 0;

        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = new Player("Player " + i, this);
            players.add(player);
            Thread thread = new Thread(player);
            playerThreads.add(thread);
        }
    }

    public void start() {
        for (Thread thread : playerThreads) {
            thread.start();
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        return bag.extractTiles(howMany);
    }

    public boolean isBagEmpty() {
        return bag.isEmpty();
    }

    public synchronized Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public synchronized void nextPlayerTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

   
}
