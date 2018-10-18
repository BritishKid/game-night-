package uk.co.rowney.gamenight.model.scoreTable;

import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public List<Player> scoreCalculation(List<Player> winnerList, List<Player> loserList) {
        List<Player> updatedList = new ArrayList<>();


        float winnerAverage = getAverageScore(winnerList);
        float loserAverage = getAverageScore(loserList);

        float probabilityWinner = Probability(winnerAverage, loserAverage);
        float probabilityLoser = Probability(loserAverage, winnerAverage);

//        EloRating(winnerAverage, loserAverage);
        float winnerChange = WinnerEloRatingChange(winnerAverage, probabilityWinner);
        for (Player player : winnerList) {
            player.setScore((int) (player.getScore() + winnerChange));
            updatedList.add(player);
        }

        float loserChange = LoserEloRatingChange(loserAverage, probabilityLoser);
        for (Player player: loserList) {
            player.setScore((int) (player.getScore() - loserChange));
            updatedList.add(player);
        }

        return updatedList;
    }

//    private double getRatingChange(float playerScore, float opponentScore) {
//        double newWinnerRating = playerScore + (15)*(1+(opponentScore-playerScore));
//        return Math.abs(newWinnerRating - playerScore);
//    }

    private float Probability(float rating1,float rating2) {
        return 1.0f * 1.0f / (1 + 1.0f * (float)(Math.pow(10, 1.0f * (rating1 - rating2) / 400)));
    }

    private float WinnerEloRatingChange(float winnerAverage, float probabilityWinner){

        float newWinnerAverage = winnerAverage + 30 * (1 - probabilityWinner);
        return Math.abs(newWinnerAverage-winnerAverage);


//        System.out.print("Ra = " + (Math.round(
//                winnerAverage * 1000000.0) / 1000000.0)
//                + " Rb = " + Math.round(loserAverage
//                * 1000000.0) / 1000000.0);
    }

    private float LoserEloRatingChange(float loserAverage, float probabilityLoser) {
        float newLoserAverage = loserAverage + 30 * (0 - probabilityLoser);
        return Math.abs(newLoserAverage - loserAverage);
    }

    private float getAverageScore(List<Player> playerList) {
        float totalScore = 0;
        int count = 0;
        for (Player player: playerList) {
            totalScore = totalScore + player.getScore();
            count++;
        }
        return totalScore/count;
    }
}
