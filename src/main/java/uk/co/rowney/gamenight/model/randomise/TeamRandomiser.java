package uk.co.rowney.gamenight.model.randomise;


import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class TeamRandomiser extends CommonRandomiser{

    public Map<String, List<Player>> createTeams(List<Player> playerList, int numberOfTeams, int sizeOfTeams) {
        Map<String, List<Player>> teams = new HashMap<>();

        for (int i = 0; i < numberOfTeams; i++) {
            List<Player> teamList = new ArrayList<>();
            for (int j = 0; j < sizeOfTeams; j++) {
                int randomNumber = getRandomForList(playerList.size());
                Player player = playerList.get(randomNumber);
                teamList.add(player);
                playerList.remove(randomNumber);
            }
            teams.put(format("Team %s", i), teamList);
        }
        return teams;
    }
}
