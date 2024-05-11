public class App {
    public static void main(String[] args) {
        int numberOfPlayers = 3; 
        int n = 100; 

        Game game = new Game(numberOfPlayers, n);
        game.start();
    }
}
