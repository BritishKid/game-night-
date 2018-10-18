package uk.co.rowney.gamenight.model.scoreTable;

import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public List<Player> scoreCalculation(List<Player> winnerList, List<Player> loserList) {
        List<Player> updatedList = new ArrayList<>();

        int winnerAverage = getAverageScore(winnerList);
        int loserAverage = getAverageScore(loserList);

        int winnerChange = getRatingChange(winnerAverage, loserAverage);
        for (Player player : winnerList) {
            player.setScore(player.getScore() + winnerChange);
            updatedList.add(player);
        }

        int loserChange = getRatingChange(loserAverage, winnerAverage);
        for (Player player: loserList) {
            player.setScore(player.getScore() + loserChange);
            updatedList.add(player);
        }

        return updatedList;
    }

    private int getRatingChange(int winnerAverage, int loserAverage) {
        int newWinnerRating = winnerAverage + (15)*(1+(loserAverage-winnerAverage/400));
        return Math.abs(newWinnerRating - winnerAverage);
    }

    private int getAverageScore(List<Player> playerList) {
        int totalScore = 0;
        int count = 0;
        for (Player player: playerList) {
            totalScore = totalScore + player.getScore();
            count++;
        }
        return totalScore/count;
    }
}
