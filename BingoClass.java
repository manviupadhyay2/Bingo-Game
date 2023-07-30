import java.util.Scanner;
class Bingo {

    Scanner s = new Scanner(System.in);

    String player;
    int gridSize;
    int turn = 0;
    int[][] bingoMatrix;
    int[] randomNum;

    Bingo(String player,int gridSize) {
        this.gridSize=gridSize;
        this.player = player;
        System.out.println("    -------------------------------HOLA " + player + "--------------------------------------");
        System.out.println();
        System.out.println("=========================" + "WELCOME TO THIS GAME OF BINGO" + "=========================");
        System.out.println("                        -------------------------------------");
        System.out.println();
        System.out.println("        FOLLOWING ARE THE RULES AND INSTRUCTIONS REGARDING THE GAME:");
        System.out.println("        ---------------------------------------------------------------------");
        System.out.println("      1.THE GRID SIZE CHOSEN BY YOU SHOULD BE AN AxA SYMMETRICAL GRID");
        System.out.println("      2.EACH PLAYER IS REQUIRED TO ENTER NUMBER FROM 1 TO AxA THEIR GRID");
        System.out.println("      3.IF SOMEONE DOESN'T WANT TO CREATE THEIR OWN GRID, THE SYSTEM WILL CREATE ONE FOR THEM");
        System.out.println("      4.EACH PLAYER SIMULTANEOUSLY IS SUPPOSED TO SPEAK OUT ANY RANDOM NUMBER ");
        System.out.println("      5.EVERY PLAYER THEN HAS TO CUT DOWN OR MARK THAT SPOKEN NUMBER IN THEIR GRID AS ZERO(0)");
        System.out.println("      6.THEN YOU HAVE TO CHECK IF YOUR ROW HORIZONTALLY OR VERTICALLY IS MARKED OR NOT");
        System.out.println("      7.IF YES, THEN YOU HAVE TO COUNT THE TOTAL NUMBER OF THOSE ROWS ");
        System.out.println("      8.THE ONE WHO WILL FIRST MARK ALL THE N No. OF ENTERED ROWS WILL BE DECLARED AS WINNER.");
        System.out.println();
        System.out.println("            ||===========================================================||");
        System.out.println("            ||                            NOTE                           ||");
        System.out.println("            ||                         ----------                        ||");
        System.out.println("            || A Player is only required to enter one number at a time.  ||");
        System.out.println("            ||           Also, no number should be repeated               ||");
        System.out.println("            ||                                                           ||");
        System.out.println("            ||===========================================================||");
        System.out.println();
        System.out.println();
        System.out.println("                   -------------LETS START THE GAME!!!1--------");

        System.out.println("HURRAH!! PLAYERS HAVE BEEN SUCCESSFULLY ALLOTTED. YOU WILL BE PLAYING WITH THE FOLLOWING PLAYERS:");
        generateRandomNum();
    }

    public void gridChoice() {
        System.out.println(" CHOOSE FROM BELOW:::");
        System.out.println(" 1.CREATING OUR OWN GRID");
        System.out.println(" 2.WILL USE THE ONE PROVIDED BY THE SYSTEM");
        System.out.println();
        System.out.print("CHOOSE FROM 1/2 :: CHOICE = ");
        int choice = s.nextInt();

        if (choice == 1) {
            System.out.println("ITS SO FANTASTIC THAT YOU WANNA CREATE YOUR OWN GRID ^o^");
            selfGrid();
        } else {
            System.out.println("NO WORRIES, THE SYSTEM IS ALWAYS READY TO DO WORK FOR YOU ^_^");
            systemGrid();
        }
    }

    public void selfGrid() {
        bingoMatrix = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print("Enter " + i + "th row " + j + "th column=");
                bingoMatrix[i][j] = s.nextInt();
            }
        }
        System.out.println("::::::HURRAH !! GRID SUCCESSFULLY CREATED. LET'S START WITH THE GAME::::::");
        gridDisplay();
    }

    public void systemGrid() {
        bingoMatrix = new int[gridSize][gridSize];
        int randomNum1 = 1;
        int randomNum2 = 2;
        int whichRandomNum = randomNum1;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (whichRandomNum == randomNum1) {
                    bingoMatrix[j][i] = randomNum1;
                    randomNum1 += 2;
                    whichRandomNum = randomNum2;
                } else {
                    bingoMatrix[i][j] = randomNum2;
                    randomNum2 += 2;
                    whichRandomNum = randomNum1;
                }
            }
        }
        gridDisplay();
    }

    public void gridDisplay() {
        System.out.println("::::::::::::::::YOUR FINAL GRID IS:::::::::::::");
        System.out.println();
        System.out.println();
        System.out.println("=================================");
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(bingoMatrix[i][j] + " ");
            }
            System.out.println();
            System.out.println("-------------------------------");
        }
        System.out.println("=================================");

    }

    public void generateRandomNum() {
        randomNum = new int[gridSize * gridSize];
        for (int i = 1; i <= gridSize * gridSize; i++) {
            randomNum[i - 1] = i;
        }

    }

    public int startGameIterations(int generatedNumber) {

        checkNumberAvailable(generatedNumber);
        checkRowCompletion();
        checkColumnCompletion();
        checkDiagonalCompletion();
        return turn;
}
    public void checkNumberAvailable(int generatedRandomNum) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (bingoMatrix[i][j] == generatedRandomNum) {
                    bingoMatrix[i][j] = 0;
                    break;
                }
            }
        }
    }

    public void checkRowCompletion() {
        for (int i = 0; i < gridSize; i++) {
            int rowCompletion = 0;
            for (int j = 0; j < gridSize; j++) {
                if (bingoMatrix[i][j] != 0) {
                    rowCompletion = -1;
                    break;
                }
            }
            if (rowCompletion == 0) {
                turn++;
            }
        }
    }

    void checkColumnCompletion() {
        for (int i = 0; i < gridSize; i++) {
            int columnCompletion = 0;
            for (int j = 0; j < gridSize; j++) {
                if (bingoMatrix[j][i] != 0) {
                    columnCompletion = -1;
                    break;
                }
            }
            if (columnCompletion == 0) {
                turn++;
            }
        }
    }

    public void checkDiagonalCompletion() {
        int diagonalCompletion = 0;
        for (int i = 0; i < gridSize; i++) {
            if (bingoMatrix[i][i] != 0) {
                diagonalCompletion = -1;
                break;
            }
        }
        if (diagonalCompletion == 0) {
            turn++;
        }
    }  
}
