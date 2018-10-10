package uk.co.rowney.gamenight.model.randomise;

import uk.co.rowney.gamenight.model.filter.Filter;
import uk.co.rowney.gamenight.model.filter.GameModeFilter;
import uk.co.rowney.gamenight.objects.gameObjects.Game;
import uk.co.rowney.gamenight.objects.gameObjects.GameMode;

import java.util.List;

public class GameModeRandomiser extends CommonRandomiser{

    public GameMode randomGameMode(Game game) {
        List<GameMode> gameModes = game.getGameModes();
        return gameModes.get(getRandomForList(gameModes.size()));
    }

    public GameMode randomTeamGameMode(Game game) {
        Filter gameModeFilter = new GameModeFilter();
        List<GameMode> gameModes = game.getGameModes();
        List<GameMode> teamGameModes = (List<GameMode>) gameModeFilter.listWithTeam(gameModes);

        return teamGameModes.get(getRandomForList(teamGameModes.size()));
    }

    public GameMode randomFfaGameMode(Game game) {
        Filter gameModeFilter = new GameModeFilter();
        List<GameMode> gameModes = game.getGameModes();
        List<GameMode> ffaGameModes = (List<GameMode>) gameModeFilter.listWithFfa(gameModes);

        return ffaGameModes.get(getRandomForList(ffaGameModes.size()));
    }
}
