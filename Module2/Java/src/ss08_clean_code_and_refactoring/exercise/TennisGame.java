package ss08_clean_code_and_refactoring.exercise;

import java.util.Scanner;

public class TennisGame {
    String displayScore = "";
    int tempScore;
    public String getFirstScore(  int firstPlayerScore, int secondPlayerScore) {
            switch (firstPlayerScore) {
                case 0:
                    displayScore = "Love-All";
                    break;
                case 1:
                    displayScore = "Fifteen-All";
                    break;
                case 2:
                    displayScore = "Thirty-All";
                    break;
                case 3:
                    displayScore = "Forty-All";
                    break;
                default:
                    displayScore = "Deuce";
                    break;

            }

        return displayScore;
    }
    public String getSecondScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore){
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult == 1) displayScore = "Advantage "+firstPlayerName;
        else if (minusResult == -1) displayScore = "Advantage "+secondPlayerName;
        else if (minusResult >= 2) displayScore = "Win for "+firstPlayerName;
        else displayScore = "Win for "+secondPlayerName;
        return displayScore;
    }
    public String getThirdScore( int firstPlayerScore, int secondPlayerScore){
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                tempScore = firstPlayerScore;
            } else {
                displayScore += "-";
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case 0:
                    displayScore += "Love";
                    break;
                case 1:
                    displayScore +="Fifteen";
                    break;
                case 2:
                    displayScore +="Thirty";
                    break;
                case 3:
                    displayScore += "Forty";
                    break;
            }
        }
        return displayScore;
    }



}
