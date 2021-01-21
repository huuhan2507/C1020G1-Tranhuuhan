package ss08_clean_code_and_refactoring.exercise;

import java.util.Scanner;

public class TennisTest {
    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name player 1: ");

        String firstPlayerName = scanner.nextLine();

        System.out.println("Enter name player 2: ");

        String secondPlayerName = scanner.nextLine();

        System.out.println("Score player 1: ");

        int firstPlayerScore = scanner.nextInt();

        System.out.println("Score player 2: ");

        int secondPlayerScore = scanner.nextInt();

        System.out.println(firstPlayerName + " vs " + secondPlayerName);

        System.out.println("Result: ");

        boolean checkFirstScore = firstPlayerScore == secondPlayerScore;

        boolean checkSecondScore = firstPlayerScore >= 4 || secondPlayerScore >= 4;

        if (checkFirstScore) {
            System.out.println(tennisGame.getFirstScore(firstPlayerScore, secondPlayerScore));
        } else if (checkSecondScore) {
            System.out.println(tennisGame.getSecondScore(firstPlayerName, secondPlayerName, firstPlayerScore, secondPlayerScore));
        } else {
            System.out.println(tennisGame.getThirdScore(firstPlayerScore, secondPlayerScore));
        }


    }
}
