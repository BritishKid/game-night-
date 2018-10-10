package uk.co.rowney.gamenight.model.randomise;

import uk.co.rowney.gamenight.model.JsonParser;
import uk.co.rowney.gamenight.model.filter.Filter;
import uk.co.rowney.gamenight.model.filter.GameFilter;
import uk.co.rowney.gamenight.objects.gameObjects.Game;
import uk.co.rowney.gamenight.objects.gameObjects.Series;

import java.io.FileNotFoundException;
import java.util.List;

public class GameRandomiser extends CommonRandomiser {

    private JsonParser jsonParser = new JsonParser();
    private List<Game> games;

    public Game randomGame(Series series) throws FileNotFoundException {
        games = jsonParser.getGameList(series.getFileName());
        return games.get(getRandomForList(games.size()));
    }

    public Game randomTeamGame(Series series) throws FileNotFoundException {
        List<Game> chosenGame = jsonParser.getGameList(series.getFileName());
        Filter filter = new GameFilter();
        games = (List<Game>) filter.listWithTeam(chosenGame);
        return games.get(getRandomForList(games.size()));
    }

    public Game randomFfaGame(Series series) throws FileNotFoundException {
        List<Game> chosenGame = jsonParser.getGameList(series.getFileName());
        Filter filter = new GameFilter();
        games = (List<Game>) filter.listWithFfa(chosenGame);
        return games.get(getRandomForList(games.size()));
    }
}
