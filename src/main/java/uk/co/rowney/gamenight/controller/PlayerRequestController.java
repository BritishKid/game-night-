package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.dao.PlayerDao;
import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.SQLException;

@RestController
public class PlayerRequestController {

    private PlayerDao playerDao = new PlayerDao();

    @RequestMapping(path="/player/get/id={playerId}")
    public Player getPlayerFromId(@PathVariable("playerId") int playerId) throws SQLException {
        return playerDao.getPlayerFromId(playerId);
    }
}

