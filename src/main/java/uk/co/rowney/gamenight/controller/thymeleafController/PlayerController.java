package uk.co.rowney.gamenight.controller.thymeleafController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.rowney.gamenight.dao.PlayerDao;
import uk.co.rowney.gamenight.model.scoreTable.Calculation;
import uk.co.rowney.gamenight.objects.tableObjects.Player;

import java.sql.SQLException;
import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    @RequestMapping(path="/player/winners={winners}&losers={losers}")
    public String updateResults(@PathVariable("winners") String winnerIds,
                                @PathVariable("losers") String loserIds) throws SQLException {
        String[] winners = winnerIds.split(",");
        String[] losers = loserIds.split(",");
        List<Player> winnerList = playerDao.getMultiplePlayersFromId(winners);
        List<Player> loserList = playerDao.getMultiplePlayersFromId(losers);

        Calculation calculation = new Calculation();
        List<Player> updatedList = calculation.scoreCalculation(winnerList, loserList);
        playerDao.updatePlayers(updatedList);

        return "updated";
    }

    @RequestMapping(path="/player/winner={winners}")
    public String updateFfaResults(@PathVariable("winners") String winnerIds) throws SQLException {
        String[] winners = winnerIds.split(",");
        List<Player> winnerList = playerDao.getMultiplePlayersFromId(winners);
        List<Player> loserList = playerDao.getAllPlayers();

        for (int i = 0; i < loserList.size(); i++) {
            if(loserList.get(i).getId() == winnerList.get(0).getId()){
                loserList.remove(i);
            }
        }

        Calculation calculation = new Calculation();
        List<Player> updatedList = calculation.scoreCalculation(winnerList, loserList);
        playerDao.updatePlayers(updatedList);

        return "updated";
    }
}
