package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    private final String[][] ticTacToe;
    private int counterX;
    private int counterO;

    public TicTacToe() {
        ticTacToe = new String[3][3];
        this.counterO = 0;
        this.counterX = 0;
    }

    @Deprecated
    public void setCells(String[] cells) {
        int counterCells = 0;

        System.out.print("---------");
        //For nested loop
        //This one is for the columns
        for (int i = 0; i < this.ticTacToe.length; i++) {
            System.out.println();
            System.out.print("| ");
            //This one is for the rows
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                //Adding a space if the input is '_'
                if (cells[counterCells].equals("_")) {
                    cells[counterCells] = " ";
                }
                //Adding the content of the cells in the parameter to the 2D Array
                this.ticTacToe[i][j] = cells[counterCells];
                System.out.print(this.ticTacToe[i][j] + " ");
                counterCells++;
                //Counting the X's and O's
                if (this.ticTacToe[i][j].equals("X")) {
                    this.counterX++;
                } else if (this.ticTacToe[i][j].equals("O")) {
                    this.counterO++;
                }
                //Adding '|' to the end of the line when the counter j == 2
                if (j == 2) {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        System.out.println("---------");
    }

    public void setEmptyBoard() {
        System.out.print("---------");
        //For nested loop
        //This one is for the columns
        for (int i = 0; i < this.ticTacToe.length; i++) {
            System.out.println();
            System.out.print("| ");
            //This one is for the rows
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                this.ticTacToe[i][j] = " ";
                System.out.print(this.ticTacToe[i][j] + " ");

                //Adding '|' to the end of the line when the counter j == 2
                if (j == 2) {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        System.out.println("---------");
    }

    public void userVsEasyAI(TicTacToe ticTacToeGame, Scanner scanner) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {
            System.out.println("Enter the coordinates:");
            String userPlays = scanner.nextLine();
            String[] userPlaysSplit = userPlays.split(" ");

            ticTacToeGame.userPlayAsX(userPlaysSplit, scanner);

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            ticTacToeGame.easyAIMoveAsO();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void easyAIVsUser(TicTacToe ticTacToeGame, Scanner scanner) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {

            ticTacToeGame.easyAIMoveAsX();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            System.out.println("Enter the coordinates:");
            String userPlays = scanner.nextLine();
            String[] userPlaysSplit = userPlays.split(" ");
            ticTacToeGame.userPlayAsO(userPlaysSplit, scanner);

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void userVsUser(TicTacToe ticTacToeGame, Scanner scanner) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {
            System.out.println("Enter the coordinates:");
            String userPlays = scanner.nextLine();
            String[] userPlaysSplit = userPlays.split(" ");

            ticTacToeGame.userPlayAsX(userPlaysSplit, scanner);

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            System.out.println("Enter the coordinates:");
            userPlays = scanner.nextLine();
            userPlaysSplit = userPlays.split(" ");

            ticTacToeGame.userPlayAsO(userPlaysSplit, scanner);

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void easyAIVsEasyAI(TicTacToe ticTacToeGame) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {

            ticTacToeGame.easyAIMoveAsX();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            ticTacToeGame.easyAIMoveAsO();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void mediumAIVsUser(TicTacToe ticTacToeGame, Scanner scanner) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {

            ticTacToeGame.mediumAIMoveAsX();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            System.out.println("Enter the coordinates:");
            String userPlays = scanner.nextLine();
            String[] userPlaysSplit = userPlays.split(" ");
            ticTacToeGame.userPlayAsO(userPlaysSplit, scanner);

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void userVsMediumAI(TicTacToe ticTacToeGame, Scanner scanner) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {

            System.out.println("Enter the coordinates:");
            String userPlays = scanner.nextLine();
            String[] userPlaysSplit = userPlays.split(" ");
            ticTacToeGame.userPlayAsX(userPlaysSplit, scanner);


            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            ticTacToeGame.mediumAIMoveAsO();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void hardAIVsUser(TicTacToe ticTacToeGame, Scanner scanner) {
        String gameStatus = "";

        //Printing and making the board to make plays
        setEmptyBoard();

        while (gameStatus.equals("") && ticTacToeGame.isBoardEmpty()) {

            ticTacToeGame.hardAIMoveAsX();

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

            System.out.println("Enter the coordinates:");
            String userPlays = scanner.nextLine();
            String[] userPlaysSplit = userPlays.split(" ");
            ticTacToeGame.userPlayAsO(userPlaysSplit, scanner);

            switch (ticTacToeGame.winCondition()) {
                case "X wins" -> {
                    gameStatus = "X wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "O wins" -> {
                    gameStatus = "O wins";
                    System.out.println(gameStatus);
                    continue;
                }
                case "Draw" -> {
                    gameStatus = "Draw";
                    System.out.println(gameStatus);
                    continue;
                }
            }

        }
    }

    public void userPlayAsX(String[] coordinates, Scanner scanner) {
        while (true) {
            try {
                int column = Integer.parseInt(coordinates[0]) - 1;
                int row = Integer.parseInt(coordinates[1]) - 1;

                if (ticTacToe[column][row].equals(" ")) {
                    ticTacToe[column][row] = "X";
                    printGameBoard();
                    break;
                } else if (ticTacToe[column][row].equals("X") || ticTacToe[column][row].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    String userCoordinates = scanner.nextLine();
                    coordinates = userCoordinates.split(" ");
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                String userCoordinates = scanner.nextLine();
                coordinates = userCoordinates.split(" ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                String userCoordinates = scanner.nextLine();
                coordinates = userCoordinates.split(" ");
            }
        }
    }

    public void userPlayAsO(String[] coordinates, Scanner scanner) {
        while (true) {
            try {
                int column = Integer.parseInt(coordinates[0]) - 1;
                int row = Integer.parseInt(coordinates[1]) - 1;

                if (ticTacToe[column][row].equals(" ")) {
                    ticTacToe[column][row] = "O";
                    printGameBoard();
                    break;
                } else if (ticTacToe[column][row].equals("X") || ticTacToe[column][row].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    String userCoordinates = scanner.nextLine();
                    coordinates = userCoordinates.split(" ");
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                String userCoordinates = scanner.nextLine();
                coordinates = userCoordinates.split(" ");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                String userCoordinates = scanner.nextLine();
                coordinates = userCoordinates.split(" ");
            }
        }
    }


    public void easyAIMoveAsO() {

        Random randomizer = new Random();
        int column = randomizer.nextInt(3);
        int row = randomizer.nextInt(3);

        while (true) {
            if (!isBoardEmpty()) {
                break;
            } else if (ticTacToe[column][row].equals(" ")) {
                ticTacToe[column][row] = "O";
                System.out.println("Making move level \"easy\"");
                printGameBoard();
                break;
            } else if (ticTacToe[column][row].equals("X") || ticTacToe[column][row].equals("O")) {
                column = randomizer.nextInt(3);
                row = randomizer.nextInt(3);
            }
        }

    }

    public void easyAIMoveAsX() {

        Random randomizer = new Random();
        int column = randomizer.nextInt(3);
        int row = randomizer.nextInt(3);

        while (true) {
            if (!isBoardEmpty()) {
                break;
            } else if (ticTacToe[column][row].equals(" ")) {
                ticTacToe[column][row] = "X";
                System.out.println("Making move level \"easy\"");
                printGameBoard();
                break;
            } else if (ticTacToe[column][row].equals("X") || ticTacToe[column][row].equals("O")) {
                column = randomizer.nextInt(3);
                row = randomizer.nextInt(3);
            }
        }

    }

    public void mediumAIMoveAsX() {
        //Counters
        int xCounter = 0;
        int oCounter = 0;
        int blankSpace = 0;

        //Using the same code as the win condition to check whether the row contains 2 or more character, if it's true
        //then it's going to proceed to play in that space

        //Verifying the rows !!
        for (int i = 0; i < 3; i++) {
            xCounter = 0;
            oCounter = 0;
            blankSpace = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    blankSpace++;
                    if (blankSpace >= 3) {
                        xCounter = 0;
                        oCounter = 0;
                        blankSpace = 0;
                    } else if (oCounter == 2 && blankSpace == 1) {
                        ticTacToe[i][j] = "X";
                        printMediumMove();
                        return;
                    } else if (xCounter == 2 && blankSpace == 1) {
                        ticTacToe[i][j] = "X";
                        printMediumMove();
                        return;
                    }
                } else if (this.ticTacToe[i][j].equals("X")) {
                    xCounter++;
                    if (xCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[i][k].equals("X") || this.ticTacToe[i][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[i][k] = "X";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                } else if (this.ticTacToe[i][j].equals("O")) {
                    oCounter++;
                    if (oCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[i][k].equals("X") || this.ticTacToe[i][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[i][k] = "X";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                }
            }
        }

        //Verifying the columns
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                blankSpace = 0;
                break;
            }
            xCounter = 0;
            oCounter = 0;
            blankSpace = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[j][i].equals(" ")) {
                    blankSpace++;
                    if (blankSpace >= 3) {
                        xCounter = 0;
                        oCounter = 0;
                        blankSpace = 0;
                    } else if (oCounter == 2 && blankSpace == 1) {
                        ticTacToe[j][i] = "X";
                        printMediumMove();
                        return;
                    } else if (xCounter == 2 && blankSpace == 1) {
                        ticTacToe[j][i] = "X";
                        printMediumMove();
                        return;
                    }
                } else if (this.ticTacToe[j][i].equals("X")) {
                    xCounter++;
                    if (xCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[k][i].equals("X") || this.ticTacToe[j][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[k][i] = "X";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                } else if (this.ticTacToe[j][i].equals("O")) {
                    oCounter++;
                    if (oCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[k][i].equals("X") || this.ticTacToe[j][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[k][i] = "X";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                }
            }
        }

        //Check the win condition diagonally
        //From the top left to down right
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                blankSpace = 0;
                break;
            }
            if (this.ticTacToe[i][i].equals(" ")) {
                blankSpace++;
                if (blankSpace >= 3) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace = 0;
                } else if (oCounter == 2 && blankSpace == 1) {
                    ticTacToe[i][i] = "X";
                    printMediumMove();
                    return;
                } else if (xCounter == 2 && blankSpace == 1) {
                    ticTacToe[i][i] = "X";
                    printMediumMove();
                    return;
                }
            } else if (this.ticTacToe[i][i].equals("X")) {
                xCounter++;
                if (xCounter == 2 && blankSpace == 1) {
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][k].equals("X") || this.ticTacToe[k][k].equals("O")) {
                            continue;
                        } else {
                            ticTacToe[k][k] = "X";
                            printMediumMove();
                            return;
                        }
                    }
                }
            } else if (this.ticTacToe[i][i].equals("O")) {
                oCounter++;
                if (oCounter == 2 && blankSpace == 1) {
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][k].equals("X") || this.ticTacToe[k][k].equals("O")) {
                            continue;
                        } else {
                            ticTacToe[k][k] = "X";
                            printMediumMove();
                            return;
                        }
                    }
                }
            }
        }


        //From the top right to down left //////////NEED TO MAKE THIS ONE WORKS AND IT'S DONE
        int j = 2;
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                blankSpace = 0;
                break;
            }
            if (this.ticTacToe[i][j].equals(" ")) {
                blankSpace++;
                j--;
                if (blankSpace >= 3) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace = 0;
                } else if (oCounter == 2 && blankSpace == 1) {
                    if (j < 0) {
                        j = 0;
                    }
                    ticTacToe[i][j] = "X";
                    printMediumMove();
                    return;
                } else if (xCounter == 2 && blankSpace == 1) {
                    if (j < 0) {
                        j = 0;
                    }
                    ticTacToe[i][j] = "X";
                    printMediumMove();
                    return;
                }
            } else if (this.ticTacToe[i][j].equals("X")) {
                xCounter++;
                j--;
                if (xCounter == 2 && blankSpace == 1) {
                    j = 2;
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][j].equals("X") || this.ticTacToe[k][j].equals("O")) {
                            continue;
                        } else {
                            ticTacToe[k][j] = "X";
                            printMediumMove();
                            return;
                        }
                    }
                }
            } else if (this.ticTacToe[i][j].equals("O")) {
                oCounter++;
                j--;
                if (oCounter == 2 && blankSpace == 1) {
                    j = 2;
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][j].equals("X") || this.ticTacToe[k][j].equals("O")) {
                            j--;
                        } else {
                            ticTacToe[k][j] = "X";
                            printMediumMove();
                            return;
                        }
                    }
                }
            }
        }

        //If any of the condition above is not met, then it's going to make a random move

        mediumAIRandomMoveAsX();

    }

    public void mediumAIMoveAsO() {
        //Counters
        int xCounter = 0;
        int oCounter = 0;
        int blankSpace = 0;

        //Using the same code as the win condition to check whether the row contains 2 or more character, if it's true
        //then it's going to proceed to play in that space

        //Verifying the rows !!
        for (int i = 0; i < 3; i++) {
            xCounter = 0;
            oCounter = 0;
            blankSpace = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    blankSpace++;
                    if (blankSpace >= 3) {
                        xCounter = 0;
                        oCounter = 0;
                        blankSpace = 0;
                    } else if (oCounter == 2 && blankSpace == 1) {
                        ticTacToe[i][j] = "O";
                        printMediumMove();
                        return;
                    } else if (xCounter == 2 && blankSpace == 1) {
                        ticTacToe[i][j] = "O";
                        printMediumMove();
                        return;
                    }
                } else if (this.ticTacToe[i][j].equals("X")) {
                    xCounter++;
                    if (xCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[i][k].equals("X") || this.ticTacToe[i][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[i][k] = "O";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                } else if (this.ticTacToe[i][j].equals("O")) {
                    oCounter++;
                    if (oCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[i][k].equals("X") || this.ticTacToe[i][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[i][k] = "O";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                }
            }
        }

        //Verifying the columns
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                blankSpace = 0;
                break;
            }
            xCounter = 0;
            oCounter = 0;
            blankSpace = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[j][i].equals(" ")) {
                    blankSpace++;
                    if (blankSpace >= 3) {
                        xCounter = 0;
                        oCounter = 0;
                        blankSpace = 0;
                    } else if (oCounter == 2 && blankSpace == 1) {
                        ticTacToe[j][i] = "O";
                        printMediumMove();
                        return;
                    } else if (xCounter == 2 && blankSpace == 1) {
                        ticTacToe[j][i] = "O";
                        printMediumMove();
                        return;
                    }
                } else if (this.ticTacToe[j][i].equals("X")) {
                    xCounter++;
                    if (xCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[k][i].equals("X") || this.ticTacToe[j][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[k][i] = "O";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                } else if (this.ticTacToe[j][i].equals("O")) {
                    oCounter++;
                    if (oCounter == 2 && blankSpace == 1) {
                        for (int k = 0; k < 3; k++) {
                            if (this.ticTacToe[k][i].equals("X") || this.ticTacToe[j][k].equals("O")) {
                                continue;
                            } else {
                                ticTacToe[k][i] = "O";
                                printMediumMove();
                                return;
                            }
                        }
                    }
                }
            }
        }

        //Check the win condition diagonally
        //From the top left to down right
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                blankSpace = 0;
                break;
            }
            if (this.ticTacToe[i][i].equals(" ")) {
                blankSpace++;
                if (blankSpace >= 3) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace = 0;
                } else if (oCounter == 2 && blankSpace == 1) {
                    ticTacToe[i][i] = "O";
                    printMediumMove();
                    return;
                } else if (xCounter == 2 && blankSpace == 1) {
                    ticTacToe[i][i] = "O";
                    printMediumMove();
                    return;
                }
            } else if (this.ticTacToe[i][i].equals("X")) {
                xCounter++;
                if (xCounter == 2 && blankSpace == 1) {
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][k].equals("X") || this.ticTacToe[k][k].equals("O")) {
                            continue;
                        } else {
                            ticTacToe[k][k] = "O";
                            printMediumMove();
                            return;
                        }
                    }
                }
            } else if (this.ticTacToe[i][i].equals("O")) {
                oCounter++;
                if (oCounter == 2 && blankSpace == 1) {
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][k].equals("X") || this.ticTacToe[k][k].equals("O")) {
                            continue;
                        } else {
                            ticTacToe[k][k] = "O";
                            printMediumMove();
                            return;
                        }
                    }
                }
            }
        }


        //From the top right to down left
        int j = 2;
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                blankSpace = 0;
                break;
            }
            if (this.ticTacToe[i][j].equals(" ")) {
                blankSpace++;
                j--;
                if (blankSpace >= 3) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace = 0;
                } else if (oCounter == 2 && blankSpace == 1) {
                    if (j < 0) {
                        j = 0;
                    }
                    ticTacToe[i][j] = "O";
                    printMediumMove();
                    return;
                } else if (xCounter == 2 && blankSpace == 1) {
                    if (j < 0) {
                        j = 0;
                    }
                    ticTacToe[i][j] = "O";
                    printMediumMove();
                    return;
                }
            } else if (this.ticTacToe[i][j].equals("X")) {
                xCounter++;
                j--;
                if (xCounter == 2 && blankSpace == 1) {
                    j = 2;
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][j].equals("X") || this.ticTacToe[k][j].equals("O")) {
                            continue;
                        } else {
                            ticTacToe[k][j] = "O";
                            printMediumMove();
                            return;
                        }
                    }
                }
            } else if (this.ticTacToe[i][j].equals("O")) {
                oCounter++;
                j--;
                if (oCounter == 2 && blankSpace == 1) {
                    j = 2;
                    for (int k = 0; k < 3; k++) {
                        if (this.ticTacToe[k][j].equals("X") || this.ticTacToe[k][j].equals("O")) {
                            j--;
                        } else {
                            ticTacToe[k][j] = "O";
                            printMediumMove();
                            return;
                        }
                    }
                }
            }
        }

        //If any of the condition above is not met, then it's going to make a random move

        mediumAIRandomMoveAsO();

    }

    public void hardAIMoveAsX() {
        int bestScore = Integer.MIN_VALUE;
        int newI = 0;
        int newJ = 0;


        for (int i = 0; i < this.ticTacToe.length; i++) {
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    int score = minimax(ticTacToe, 5, true);
                    if (score > bestScore) {
                        bestScore = score;

//                        if (bestScore >= 1) {
//                            System.out.println("Making move level \"hard\"");
//                            this.ticTacToe[i][j] = "X";
//                            printGameBoard();
//                            break;
//                        }
                        newI = i;
                        newJ = j;
                    }
                }
            }
        }
        System.out.println("Making move level \"hard\"");
        this.ticTacToe[newI][newJ] = "X";
        printGameBoard();
    }

//    public void hardAIMoveAsX() {
//        int bestScore = Integer.MIN_VALUE;
//        int newI = 0;
//        int newJ = 0;
//
//        for (int i = 0; i < this.ticTacToe.length; i++) {
//            for (int j = 0; j < this.ticTacToe[i].length; j++) {
//                if (this.ticTacToe[i][j].equals(" ")) {
//                    this.ticTacToe[i][j] = "X";
//                    int score = minimax(ticTacToe, 5, false);
//                    if (score > bestScore) {
//                        bestScore = score;
//                        newI = i;
//                        newJ = j;
//                    }
//                }
//            }
//        }
//        System.out.println("Making move level \"hard\"");
//        this.ticTacToe[newI][newJ] = "X";
//        printGameBoard();
//    }

    public void mediumAIRandomMoveAsX() {

        Random randomizer = new Random();
        int column = randomizer.nextInt(3);
        int row = randomizer.nextInt(3);

        while (true) {
            if (!isBoardEmpty()) {
                break;
            } else if (ticTacToe[column][row].equals(" ")) {
                ticTacToe[column][row] = "X";
                System.out.println("Making move level \"medium\"");
                printGameBoard();
                break;
            } else if (ticTacToe[column][row].equals("X") || ticTacToe[column][row].equals("O")) {
                column = randomizer.nextInt(3);
                row = randomizer.nextInt(3);
            }
        }

    }

    public void mediumAIRandomMoveAsO() {

        Random randomizer = new Random();
        int column = randomizer.nextInt(3);
        int row = randomizer.nextInt(3);

        while (true) {
            if (!isBoardEmpty()) {
                break;
            } else if (ticTacToe[column][row].equals(" ")) {
                ticTacToe[column][row] = "O";
                System.out.println("Making move level \"medium\"");
                printGameBoard();
                break;
            } else if (ticTacToe[column][row].equals("X") || ticTacToe[column][row].equals("O")) {
                column = randomizer.nextInt(3);
                row = randomizer.nextInt(3);
            }
        }

    }

    public void printMediumMove() {
        System.out.println("Making move level \"medium\"");
        printGameBoard();
    }

    public String winCondition() {
        //Counters
        int xCounter = 0;
        int oCounter = 0;
        int blankSpace = 0;

        //There are 8 conditions to win, lets check one by one

        //Checks the win condition for the rows
        for (int i = 0; i < 3; i++) {
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace++;
                    break;
                } else if (this.ticTacToe[i][j].equals("X")) {
                    xCounter++;
                    if (xCounter == 3) {
                        return "X wins";
                    }
                } else if (this.ticTacToe[i][j].equals("O")) {
                    oCounter++;
                    if (oCounter == 3) {
                        return "O wins";
                    }
                }
            }
        }

        //Checks the win conditions for the columns
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                break;
            }
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[j][i].equals(" ")) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace++;
                    break;
                } else if (this.ticTacToe[j][i].equals("X")) {
                    xCounter++;
                    if (xCounter == 3) {
                        return "X wins";
                    }
                } else if (this.ticTacToe[j][i].equals("O")) {
                    oCounter++;
                    if (oCounter == 3) {
                        return "O wins";
                    }
                }
            }
        }

        //Check the win condition diagonally
        //From the top left to down right
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                break;
            }
            if (this.ticTacToe[i][i].equals(" ")) {
                xCounter = 0;
                oCounter = 0;
                blankSpace++;
                break;
            } else if (this.ticTacToe[i][i].equals("X")) {
                xCounter++;
                if (xCounter == 3) {
                    return "X wins";
                }
            } else if (this.ticTacToe[i][i].equals("O")) {
                oCounter++;
                if (oCounter == 3) {
                    return "O wins";
                }
            }
        }


        //From the down left to top right
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (this.ticTacToe[i][j].equals(" ")) {
                xCounter = 0;
                oCounter = 0;
                blankSpace++;
                break;
            } else if (this.ticTacToe[i][j].equals("X")) {
                xCounter++;
                j--;
                if (xCounter == 3) {
                    return "X wins";
                }
            } else if (this.ticTacToe[i][j].equals("O")) {
                oCounter++;
                j--;
                if (oCounter == 3) {
                    return "O wins";
                }
            }
        }

        //If there's any blank space on the board then the 'Game is not finished'
        if (blankSpace >= 1) {
            return "Game not finished";
        }

        //If there's no win conditions at all then it's a 'Draw'
        return "Draw";
    }

    public boolean isGameOver() {
        //Counters
        int xCounter = 0;
        int oCounter = 0;
        int blankSpace = 0;

        //There are 8 conditions to win, lets check one by one

        //Checks the win condition for the rows
        for (int i = 0; i < 3; i++) {
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace++;
                    break;
                } else if (this.ticTacToe[i][j].equals("X")) {
                    xCounter++;
                    if (xCounter == 3) {
                        return true;
                    }
                } else if (this.ticTacToe[i][j].equals("O")) {
                    oCounter++;
                    if (oCounter == 3) {
                        return true;
                    }
                }
            }
        }

        //Checks the win conditions for the columns
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                break;
            }
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[j][i].equals(" ")) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace++;
                    break;
                } else if (this.ticTacToe[j][i].equals("X")) {
                    xCounter++;
                    if (xCounter == 3) {
                        return true;
                    }
                } else if (this.ticTacToe[j][i].equals("O")) {
                    oCounter++;
                    if (oCounter == 3) {
                        return true;
                    }
                }
            }
        }

        //Check the win condition diagonally
        //From the top left to down right
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                break;
            }
            if (this.ticTacToe[i][i].equals(" ")) {
                xCounter = 0;
                oCounter = 0;
                blankSpace++;
                break;
            } else if (this.ticTacToe[i][i].equals("X")) {
                xCounter++;
                if (xCounter == 3) {
                    return true;
                }
            } else if (this.ticTacToe[i][i].equals("O")) {
                oCounter++;
                if (oCounter == 3) {
                    return true;
                }
            }
        }


        //From the down left to top right
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (this.ticTacToe[i][j].equals(" ")) {
                xCounter = 0;
                oCounter = 0;
                blankSpace++;
                break;
            } else if (this.ticTacToe[i][j].equals("X")) {
                xCounter++;
                j--;
                if (xCounter == 3) {
                    return true;
                }
            } else if (this.ticTacToe[i][j].equals("O")) {
                oCounter++;
                j--;
                if (oCounter == 3) {
                    return true;
                }
            }
        }

        //If there's any blank space on the board then the 'Game is not finished'
        if (blankSpace >= 1) {
            return false;
        }

        return false;
    }

    public int evaluate() {
        //Counters
        int xCounter = 0;
        int oCounter = 0;
        int blankSpace = 0;

        //There are 8 conditions to win, lets check one by one

        //Checks the win condition for the rows
        for (int i = 0; i < 3; i++) {
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace++;
                    break;
                } else if (this.ticTacToe[i][j].equals("X")) {
                    xCounter++;
                    if (xCounter == 3) {
                        return 10;
                    }
                } else if (this.ticTacToe[i][j].equals("O")) {
                    oCounter++;
                    if (oCounter == 3) {
                        return -10;
                    }
                }
            }
        }

        //Checks the win conditions for the columns
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                break;
            }
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ticTacToe[j][i].equals(" ")) {
                    xCounter = 0;
                    oCounter = 0;
                    blankSpace++;
                    break;
                } else if (this.ticTacToe[j][i].equals("X")) {
                    xCounter++;
                    if (xCounter == 3) {
                        return 10;
                    }
                } else if (this.ticTacToe[j][i].equals("O")) {
                    oCounter++;
                    if (oCounter == 3) {
                        return -10;
                    }
                }
            }
        }

        //Check the win condition diagonally
        //From the top left to down right
        for (int i = 0; i <= 3; i++) {
            //Breaking and resetting the variables after checking this condition
            if (i == 3) {
                xCounter = 0;
                oCounter = 0;
                break;
            }
            if (this.ticTacToe[i][i].equals(" ")) {
                xCounter = 0;
                oCounter = 0;
                blankSpace++;
                break;
            } else if (this.ticTacToe[i][i].equals("X")) {
                xCounter++;
                if (xCounter == 3) {
                    return 10;
                }
            } else if (this.ticTacToe[i][i].equals("O")) {
                oCounter++;
                if (oCounter == 3) {
                    return -10;
                }
            }
        }


        //From the down left to top right
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (this.ticTacToe[i][j].equals(" ")) {
                xCounter = 0;
                oCounter = 0;
                blankSpace++;
                break;
            } else if (this.ticTacToe[i][j].equals("X")) {
                xCounter++;
                j--;
                if (xCounter == 3) {
                    return 10;
                }
            } else if (this.ticTacToe[i][j].equals("O")) {
                oCounter++;
                j--;
                if (oCounter == 3) {
                    return -10;
                }
            }
        }

        //If there's any blank space on the board then the 'Game is not finished'
        if (blankSpace >= 1) {
            return 0;
        }

        return 0;
    }

    public int minimax(String[][] ticTacToe, int depth, boolean isMaximizer) {
        //Check if the game has ended or if maximum depth has been reached, depth should be the remaining spaces
        if (isGameOver() || depth == 0) {
            return evaluate();
        }

        //If the current player is the maximizer
        if (isMaximizer) {
            int bestScore = Integer.MIN_VALUE;
            //Iterating over all possible moves
            for (int i = 0; i < this.ticTacToe.length; i++) {
                for (int j = 0; j < this.ticTacToe[i].length; j++) {
                    if (this.ticTacToe[i][j].equals(" ")) {
                        //Making the move
                        this.ticTacToe[i][j] = "X";
                        //Recursively calling minimax with decreased depth and switch to minimizer
                        int score = minimax(ticTacToe, depth - 1, false);
                        //Undo the move
                        this.ticTacToe[i][j] = " ";
                        //Update the best score
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            //Iterating over all possible moves
            for (int i = 0; i < this.ticTacToe.length; i++) {
                for (int j = 0; j < this.ticTacToe[i].length; j++) {
                    if (this.ticTacToe[i][j].equals(" ")) {
                        //Making the move
                        this.ticTacToe[i][j] = "O";
                        //Recursively calling minimax with decreased depth and switch to maximizer
                        int score = minimax(ticTacToe, depth - 1, true);
                        //Undo the move
                        this.ticTacToe[i][j] = " ";
                        //Update the best score
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }

    public void printGameBoard() {
        System.out.print("---------");
        //For nested loop
        //This one is for the columns
        for (int i = 0; i < this.ticTacToe.length; i++) {
            System.out.println();
            System.out.print("| ");
            //This one is for the rows
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                System.out.print(this.ticTacToe[i][j] + " ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
        System.out.println("---------");
    }

    public int remainingSpaces() {
        int counterSpaces = 0;
        //For nested loop
        //This one is for the columns
        for (int i = 0; i < this.ticTacToe.length; i++) {
            //This one is for the rows
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    counterSpaces++;
                }
            }
        }
        return counterSpaces;
    }

    public boolean isBoardEmpty() {
        for (int i = 0; i < this.ticTacToe.length; i++) {
            //For nested loop
            //This one is for the columns
            for (int j = 0; j < this.ticTacToe[i].length; j++) {
                if (this.ticTacToe[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

}
