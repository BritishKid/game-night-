package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.*;
import uk.co.rowney.gamenight.dao.PlayerDao;

import java.sql.SQLException;

@RestController
public class PlayerController {

    @RequestMapping(path="/addplayer/name={playerName}")
    public String addNewPlayer(@PathVariable("playerName") String playerName) throws SQLException {

        PlayerDao playerDao = new PlayerDao();
        playerDao.addNewPlayer(playerName);

        return "Successful created new player: " + playerName;
    }
}

