package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String board[];
    static String turn;


    public static void main(String[] args) {
        board = new String[9];
        turn = "X";
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        printBoard();
        Scanner sc = new Scanner(System.in);
        String winner = null;

        System.out.println("X' s turn, Please play");
        System.out.println();
        while (winner == null) {
            int inputCell;
            inputCell = sc.nextInt();
            if (inputCell <= 0 || inputCell > 9) {
                System.out.println("You have entered wrong input, please try with the correct one");
                continue;
            } else if (!(board[inputCell - 1].equals(String.valueOf(inputCell)))) {
                System.out.println("The cell has already been filled, please select the different one");
                continue;
            } else {
                board[inputCell - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else if (turn.equals("O")) {
                    turn = "X";
                }
            }
            winner = checkWinner();
            printBoard();
            if(winner == null) {
                continue;
            }
            if (winner.equalsIgnoreCase("Draw")) {
                System.out.println("Gama is draw, thanks for playing");
                break;
            } else if (winner.equalsIgnoreCase("X")) {
                System.out.println("PLayer x win congratulations !");
            } else if (winner.equalsIgnoreCase("O")) {
                System.out.println("PLayer O win congratulations !");
            }

        }
    }

    private static void printBoard() {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[index++] + " ");
            }
            System.out.println();
        }
    }

    private static String checkWinner() {
        for (int cellNumber = 0; cellNumber < 8; cellNumber++) {
            String line = null;
            switch (cellNumber) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8) {
                return "Draw";
            }
        }

        System.out.println("Player " + turn + "'s turn");
        return null;
    }
}



