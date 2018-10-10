package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.dao.PlayerDao;
import uk.co.rowney.gamenight.model.randomise.TeamRandomiser;
import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
public class TeamRequestController {

    @RequestMapping("/teams/create")
    public Map<String, List<Player>> createTeams() throws SQLException {

        PlayerDao playerDao = new PlayerDao();
        List<Player> playerList = playerDao.getAllPlayers();

        TeamRandomiser teamRandomiser = new TeamRandomiser();
        return teamRandomiser.createTeams(playerList, 2, 2);
    }
}
