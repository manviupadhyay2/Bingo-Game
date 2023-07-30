import java.util.Scanner;
public class bingoGame {
    public static void main(String[] args) {
        Bingo player1 = new Bingo("JAKE",5);
        player1.gridChoice();
        Bingo player2 = new Bingo("SAM",5);
        player2.gridChoice();
        Bingo player3 = new Bingo("TEENA",5);
        player3.gridChoice();
        Bingo player4 = new Bingo("ALEXA",5);
        player4.gridChoice();

        int sizeOfGrid=player1.gridSize;
        int numberGeneration=0;

        boolean winnerFound = false;

        for (int i = 0; i < sizeOfGrid * sizeOfGrid; i++) {
            int result1 = player1.startGameIterations(player1.randomNum[numberGeneration]);
            int result2 = player2.startGameIterations(player2.randomNum[numberGeneration]);
            int result3 = player3.startGameIterations(player3.randomNum[numberGeneration]);
            int result4 = player4.startGameIterations(player4.randomNum[numberGeneration]);
            numberGeneration++;

            if (result1 == sizeOfGrid) {
                System.out.println("YAYYYYYYY RESULT DECLARED JAKE IS THE WINNER");
                System.out.println("^--^ YAYY SO JAKE GOT THE BINGO FIRST SO JAKE IS DECLARED AS THE WINNER ^--^");
                winnerFound = true;
                break;
            } else if (result2 == sizeOfGrid) {
                System.out.println("YAYYYYYYY RESULT DECLARED SAM IS THE WINNER");
                System.out.println("^--^ YAYY SO SAM GOT THE BINGO FIRST SO SAM IS DECLARED AS THE WINNER ^--^");
                winnerFound = true;
                break;
            } else if (result3 == sizeOfGrid) {
                System.out.println("YAYYYYYYY RESULT DECLARED TEENA IS THE WINNER");
                System.out.println("^--^ YAYY SO TEENA GOT THE BINGO FIRST SO TEENA IS DECLARED AS THE WINNER ^--^");
                winnerFound = true;
                break;
            } else if (result4 == sizeOfGrid) {
                System.out.println("YAYYYYYYY RESULT DECLARED ALEXA IS THE WINNER");
                System.out.println("^--^ YAYY SO ALEXA GOT THE BINGO FIRST SO ALEXA IS DECLARED AS THE WINNER ^--^");
                winnerFound = true;
                break;
            }
        }

        if (!winnerFound) {
            System.out.println("No winner. The game ended without a bingo.");
        }

        System.out.println();
        System.out.println("==========================THANK YOU FOR PLAYING THIS GAME===========================");
        System.out.println("                      --------------------------------------------");
        System.out.println("-----------------------------HOPING TO SEE YOU AGAIN--------------------------------");
        System.out.println("---------------------------------HAVE A NICE DAY!!!!--------------------------------");
        System.out.println("------------------------------------GOOD BYE ^__^-----------------------------------");
        System.out.println("======================================================================================");
    }
}
