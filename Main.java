package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToeGame = new TicTacToe();

        while (true) {
            System.out.println("Input command:");
            String userInput = scanner.nextLine();
            String[] userInputArray = userInput.split(" ");

            if (userInput.equals("exit")) {
                break;
            } else if (userInputArray.length < 3) {
                System.out.println("Bad parameters!");
            } else if (userInputArray[1].equals("user") && userInputArray[2].equals("easy")) {
                ticTacToeGame.userVsEasyAI(ticTacToeGame, scanner);
            } else if (userInputArray[1].equals("easy") && userInputArray[2].equals("user")) {
                ticTacToeGame.easyAIVsUser(ticTacToeGame, scanner);
            } else if (userInputArray[1].equals("easy") && userInputArray[2].equals("easy")) {
                ticTacToeGame.easyAIVsEasyAI(ticTacToeGame);
            } else if (userInputArray[1].equals("user") && userInputArray[2].equals("user")) {
                ticTacToeGame.userVsUser(ticTacToeGame, scanner);
            } else if (userInputArray[1].equals("medium") && userInputArray[2].equals("user")) {
                ticTacToeGame.mediumAIVsUser(ticTacToeGame, scanner);
            } else if (userInputArray[1].equals("user") && userInputArray[2].equals("medium")) {
                ticTacToeGame.userVsMediumAI(ticTacToeGame, scanner);
            } else if (userInputArray[1].equals("hard") && userInputArray[2].equals("user")) {
                ticTacToeGame.hardAIVsUser(ticTacToeGame, scanner);
            }
        }
    }
}
