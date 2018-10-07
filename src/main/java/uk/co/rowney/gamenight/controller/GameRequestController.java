 package uk.co.rowney.gamenight.controller;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.config.ApiClientConfiguration;
import uk.co.rowney.gamenight.model.Randomise;
import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.GameMode;

import java.io.FileNotFoundException;

@RestController
public class GameRequestController {

    private static Logger LOG = LoggerFactory.getLogger(ApiClientConfiguration.class);

    @RequestMapping("/game")
    public String getRandomGame() throws FileNotFoundException {

        Randomise randomise = new Randomise();
        Game chosenGame = randomise.randomGame();
        LOG.debug("Game selected " + chosenGame.getName());
        return "Random game selected: " + chosenGame.getName();
    }

    @RequestMapping("/gamemode")
    public String getGameandMode() throws FileNotFoundException {

        Randomise randomise = new Randomise();
        Game chosenGame = randomise.randomGame();
        LOG.debug("Game selected " + chosenGame.getName());

        GameMode chosenGameMode = randomise.randomGameMode(chosenGame);
        LOG.debug("Game selected " + chosenGameMode.getName());

        return "Random game selected: " + chosenGame.getName() +
                "\n Game Mode: " + chosenGameMode.getName();
    }


}
