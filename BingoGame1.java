import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BingoGame1 {
    private int gridSize;
    private int[][] grid;
    private int[] numbers;
    private boolean[] markedNumbers;
    private Random random;
    private Scanner scanner;

    public BingoGame1(int gridSize) {
        this.gridSize = gridSize;
        grid = new int[gridSize][gridSize];
        numbers = new int[gridSize * gridSize];
        markedNumbers = new boolean[gridSize * gridSize];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void play() {
        generateGrid();
        generateNumbers();

        System.out.println("=== BINGO GAME ===");
        System.out.println("Grid Size: " + gridSize);
        System.out.println();

        while (true) {
            int number = drawNumber();
            markNumber(number);
            displayGrid();

            if (checkWin()) {
                System.out.println("BINGO! You've won!");
                break;
            }

            System.out.print("Press enter to continue...");
            scanner.nextLine();
            System.out.println();
        }

        scanner.close();
    }

    private void generateGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = (i * gridSize) + j + 1;
            }
        }
    }

    private void generateNumbers() {
        for (int i = 0; i < gridSize * gridSize; i++) {
            numbers[i] = i + 1;
        }
        shuffleNumbers();
    }

    private void shuffleNumbers() {
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    private int drawNumber() {
        int number = numbers[0];
        System.out.println("Drawn Number: " + number);
        shiftNumbers();
        return number;
    }

    private void shiftNumbers() {
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[numbers.length - 1] = 0;
    }

    private void markNumber(int number) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == number) {
                    markedNumbers[number - 1] = true;
                    grid[i][j] = 0;
                    return;
                }
            }
        }
    }

    private void displayGrid() {
        System.out.println("Grid:");
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("X\t");
                } else {
                    System.out.print(grid[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean checkWin() {
        // Check rows
        for (int i = 0; i < gridSize; i++) {
            if (isRowComplete(i)) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < gridSize; i++) {
            if (isColumnComplete(i)) {
                return true;
            }
        }

        // Check diagonals
        if (isDiagonalComplete() || isAntiDiagonalComplete()) {
            return true;
        }

        return false;
    }

    private boolean isRowComplete(int row) {
        for (int i = 0; i < gridSize; i++) {
            if (!markedNumbers[grid[row][i] - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnComplete(int col) {
        for (int i = 0; i < gridSize; i++) {
            if (!markedNumbers[grid[i][col] - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalComplete() {
        for (int i = 0; i < gridSize; i++) {
            if (!markedNumbers[grid[i][i] - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isAntiDiagonalComplete() {
        for (int i = 0; i < gridSize; i++) {
            if (!markedNumbers[grid[i][gridSize - i - 1] - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grid size: ");
        int gridSize = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        BingoGame1 game = new BingoGame1(gridSize);
        game.play();
    }
}
