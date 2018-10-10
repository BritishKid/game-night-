package uk.co.rowney.gamenight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.rowney.gamenight.dao.PlayerDao;
import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {


    private PlayerDao playerDao = new PlayerDao();

    @RequestMapping(path="/player/add/name={playerName}")
    public String addNewPlayer(@PathVariable("playerName") String playerName) throws SQLException {
        playerDao.addNewPlayer(playerName);

        return "Successful created new player: " + playerName;
    }

    @RequestMapping(path="/player/get/id={playerId}")
    public Player getPlayerFromId(@PathVariable("playerId") int playerId) throws SQLException {
        Player player = playerDao.getPlayerFromId(playerId);
        return player;
    }

    @RequestMapping(path="/player/get/allplayers")
    public List<Player> getAllPlayers() throws SQLException {
        List<Player> playerList = playerDao.getAllPlayers();
        return playerList;
    }

}

