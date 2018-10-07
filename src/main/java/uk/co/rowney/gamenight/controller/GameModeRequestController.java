package uk.co.rowney.gamenight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rowney.gamenight.model.Randomise.GameModeRandomiser;
import uk.co.rowney.gamenight.model.Randomise.GameRandomiser;
import uk.co.rowney.gamenight.model.Randomise.SeriesRandomiser;
import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.GameMode;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;

@RestController
public class GameModeRequestController {

    private SeriesRandomiser seriesRandomiser = new SeriesRandomiser();
    private GameRandomiser gameRandomiser = new GameRandomiser();
    private GameModeRandomiser gameModeRandomiser = new GameModeRandomiser();


    @RequestMapping("/gamemode")
    public String getGameMode() throws FileNotFoundException {
        Series chosenSeries = seriesRandomiser.randomSeries();
        Game chosenGame = gameRandomiser.randomGame(chosenSeries);
        GameMode chosenGameMode = gameModeRandomiser.randomGameMode(chosenGame);

        return "Random game selected: " + chosenGame.getName() +
                "\n Game Mode: " + chosenGameMode.getName();
    }

    @RequestMapping("/gamemode/team")
    public String getRandomTeamGameMode() throws FileNotFoundException {
        Series chosenSeries = seriesRandomiser.randomTeamSeries();
        Game chosenGame = gameRandomiser.randomTeamGame(chosenSeries);
        GameMode chosenGameMode = gameModeRandomiser.randomTeamGameMode(chosenGame);

        return "Random game selected: " + chosenGame.getName() +
                "\n Game Mode: " + chosenGameMode.getName();    }

    @RequestMapping("/gamemode/ffa")
    public String getRandomFfaGameMode() throws FileNotFoundException {
        Series chosenSeries = seriesRandomiser.randomFfaSeries();
        Game chosenGame = gameRandomiser.randomFfaGame(chosenSeries);
        GameMode chosenGameMode = gameModeRandomiser.randomFfaGameMode(chosenGame);

        return "Random game selected: " + chosenGame.getName() +
                "\n Game Mode: " + chosenGameMode.getName();    }
}
