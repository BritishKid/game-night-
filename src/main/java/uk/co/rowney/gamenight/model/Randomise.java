package uk.co.rowney.gamenight.model;

import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.GameMode;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Randomise {

    private JsonParser jsonParser = new JsonParser();

    public Series randomSeries() throws FileNotFoundException {
        List<Series> seriesList = jsonParser.getSeriesList();
        return seriesList.get(getRandomForList(seriesList.size()));
    }

    private int getRandomForList(int listLength) {
        return (int) (Math.random() * listLength);
    }

    public Game randomGame() throws FileNotFoundException {
        Series randomSeries = randomSeries();
        List<Game> chosenGame = jsonParser.getGameList(randomSeries.getFileName());
        return chosenGame.get(getRandomForList(chosenGame.size()));
    }

    public GameMode randomGameMode(Game chosenGame) {
        List<GameMode> gameModes = chosenGame.getGameModes();
        return gameModes.get(getRandomForList(gameModes.size()));
    }
}