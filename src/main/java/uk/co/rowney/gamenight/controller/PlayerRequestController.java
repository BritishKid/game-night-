package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.dao.PlayerDao;
import uk.co.rowney.gamenight.model.scoreTable.Calculation;
import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PlayerRequestController {

    private PlayerDao playerDao = new PlayerDao();

    @RequestMapping(path="/player/add/name={playerName}")
    public String addNewPlayer(@PathVariable("playerName") String playerName) throws SQLException {
        playerDao.addNewPlayer(playerName);

        return "Successful created new player: " + playerName;
    }

    @RequestMapping(path="/player/get/id={playerId}")
    public Player getPlayerFromId(@PathVariable("playerId") int playerId) throws SQLException {
        return playerDao.getPlayerFromId(playerId);
    }

    @RequestMapping(path="/player/get/allplayers")
    public List<Player> getAllPlayers() throws SQLException {
        return playerDao.getAllPlayers();
    }

//    @RequestMapping(value="/player/winner={playerIds}")
//    public String updateScoreForWinner(@PathVariable String[] playerIds) throws SQLException {
//        playerDao.updatePlayersScores(playerIds);
//        return "Scores updated";
//    }


}

