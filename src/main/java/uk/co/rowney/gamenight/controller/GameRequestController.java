 package uk.co.rowney.gamenight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.config.ApiClientConfiguration;
import uk.co.rowney.gamenight.model.randomise.GameRandomiser;
import uk.co.rowney.gamenight.model.randomise.SeriesRandomiser;
import uk.co.rowney.gamenight.objects.gameObjects.Game;
import uk.co.rowney.gamenight.objects.gameObjects.Series;

import java.io.FileNotFoundException;

@RestController
public class GameRequestController {

    private SeriesRandomiser seriesRandomiser = new SeriesRandomiser();
    private GameRandomiser gameRandomiser = new GameRandomiser();
    private static Logger LOG = LoggerFactory.getLogger(ApiClientConfiguration.class);

    @RequestMapping("/game")
    public String getRandomGame() throws FileNotFoundException {
        Series chosenSeries = seriesRandomiser.randomSeries();
        Game chosenGame = gameRandomiser.randomGame(chosenSeries);
        LOG.debug("Game selected " + chosenGame.getName());
        return "Random game selected: " + chosenGame.getName();
    }

    @RequestMapping("/game/team")
    public String getRandomTeamGame() throws FileNotFoundException {
        Series chosenSeries = seriesRandomiser.randomTeamSeries();
        Game chosenGame = gameRandomiser.randomTeamGame(chosenSeries);
        LOG.debug("Game selected " + chosenGame.getName());
        return "Random team game selected: " + chosenGame.getName();
    }

    @RequestMapping("/game/ffa")
    public String getRandomFfaGame() throws FileNotFoundException {
        Series chosenSeries = seriesRandomiser.randomFfaSeries();
        Game chosenGame = gameRandomiser.randomFfaGame(chosenSeries);
        LOG.debug("Game selected " + chosenGame.getName());
        return "Random FFA game selected: " + chosenGame.getName();
    }
}
