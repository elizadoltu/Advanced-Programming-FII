/**
 * This class is for the solutions of Lab 1 for Advanced Programming FII UAIC.
 * 
 * @author Eliza Doltu
 */

public class App {

    // Define constants
    static final int NUM_LANGUAGES = 10;
    static final int NUM_VERTICES = 4;

    // Language array
    static String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

    /**
     * Main method to test the functionality
     * 
     * @param args
     * @param NUM_LANGUAGES for String languages
     * @param NUM_VERTICESB mainly to verify that the class Cycles is working
     * @param Cycles main class for DFS search 
     * 
     */
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        // Check if enough arguments are provided
        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        // Parse command line arguments
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int kFactor = Integer.parseInt(args[2]);

        // Generate a random number
        int n = (int) (Math.random() * 1_000_000);

        // Calculate result1
        int result1 = n * 3;
        int binaryToInt = Integer.parseInt("10101", 2);
        int hexToInt = Integer.parseInt("FF", 16);
        result1 += binaryToInt;
        result1 += hexToInt;
        result1 *= 6;

        // Calculate sum of digits
        int sum = sumOfDigits(result1);
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);

        // Find all k-reductible numbers
        allKReductibleNumbers(a, b, kFactor);

        System.out.println("Command line arguments:");
        for (String arg : args) {
            System.out.println(arg);
        }

        int[][] adjacencyMatrix = WheelGraphMatrix(NUM_VERTICES);
        System.out.println("Adjacency matrix of wheel graph:");
        printMatrix(adjacencyMatrix);

        int numCycles = Cycles.numberOfCycles(adjacencyMatrix);
        System.out.println("Number of cycles in the graph: " + numCycles);
        System.out.println((NUM_VERTICES * NUM_VERTICES - 3 * NUM_VERTICES + 3) == numCycles);

        // After an investigation
        // So, i did the clasic DFS search for all the cycles (in theory)
        // And i tested with the wheel graph, why ther number is different with the one if i use the formula?!?!? 

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        long elapsedTimeMilliseconds = elapsedTime / 1_000_000;
        System.out.println("Running time in nanoseconds: " + elapsedTime);
        System.out.println("Running time in milliseconds: " + elapsedTimeMilliseconds);
    }

    // Recursive method for sum of digits
    /**
     * 
     * @param number
     * @return the sum of digits in a recursive way. till the number has a digit
     */
    public static int sumOfDigits(int number) {
        int prevSum = 0;
        while (number > 0) {
            prevSum += number % 10;
            number /= 10;
        }
        return (prevSum < 10) ? prevSum : sumOfDigits(prevSum);
    }

    /**
     * 
     * @param number
     * @param kFactor
     * @return true or false if the number is k-reductible
     */
    // Method to check if a number is k-reductible
    public static boolean intKReductible(int number, int kFactor) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 2);
            number /= 10;
        }
        return (sum >= 10) ? intKReductible(sum, kFactor) : (sum == kFactor);
    }

    /**
     * 
     * @param a
     * @param b
     * @param kFactor
     */
    // Function to find all k-reductible numbers in a range
    public static void allKReductibleNumbers(int a, int b, int kFactor) {
        System.out.println("K-reductible numbers:");
        for (int index = a; index <= b; ++index) {
            if (intKReductible(index, kFactor)) {
                System.out.println(index);
            }
        }
    }

    /**
     * 
     * @param verticesNumber
     * @return the adjacency matrix of a wheel ghraph based on the number of vertices
     */
    // Function to generate the adjacency matrix of a wheel graph
    public static int[][] WheelGraphMatrix(int verticesNumber) {
        int[][] adjacencyMatrix = new int[verticesNumber][verticesNumber];
        for (int index = 1; index < verticesNumber; ++index) {
            adjacencyMatrix[0][index] = 1;
            adjacencyMatrix[index][0] = 1;
        }
        for (int index = 1; index < verticesNumber - 1; ++index) {
            adjacencyMatrix[index][index + 1] = 1;
            adjacencyMatrix[index + 1][index] = 1;
        }
        adjacencyMatrix[verticesNumber - 1][1] = 1;
        adjacencyMatrix[1][verticesNumber - 1] = 1;
        return adjacencyMatrix;
    }

    /**
     * 
     * @param matrix
     */
    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
