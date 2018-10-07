package uk.co.rowney.gamenight.model;

import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.GameMode;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonRandomiser {

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

    public GameMode randomTeamGameMode(Game chosenGame) {



        List<GameMode> gameModes = new ArrayList<>();
        List<GameMode> filteredList = new ArrayList<>();
        boolean validGame = false;



        while(!validGame) {
            gameModes = chosenGame.getGameModes();
            filteredList = gameModes.stream()
                    .filter(GameMode::isTeam)
                    .collect(Collectors.toList());
            if (filteredList.size() != 0){
                validGame = true;
            }
        }
        return filteredList.get(getRandomForList(filteredList.size()));
    }

    public GameMode randomSoloGameMode(Game chosenGame) {
        List<GameMode> gameModes = chosenGame.getGameModes();
        List<GameMode> filteredList = gameModes.stream()
                .filter(GameMode::isFfa)
                .collect(Collectors.toList());

        return filteredList.get(getRandomForList(filteredList.size()));
    }

    public Game randomTeamGame() {
        return null;
    }
}