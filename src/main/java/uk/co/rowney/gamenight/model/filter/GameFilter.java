package uk.co.rowney.gamenight.model.filter;

import uk.co.rowney.gamenight.objects.gameObjects.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameFilter implements Filter {

    private List<Game> filteredList;

    @Override
    public List<Game> listWithTeam(List<?> gameList) {
        List<Game> games = new ArrayList<>();

        castListToGame(gameList, games);

        filteredList = games.stream()
                .filter(Game::hasTeamModes)
                .collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List<Game> listWithFfa(List<?> gameList) {
        List<Game> games =  new ArrayList<>();

        castListToGame(gameList, games);

        filteredList = games.stream()
                .filter(Game::hasFfaModes)
                .collect(Collectors.toList());
        return filteredList;
    }

    private void castListToGame(List<?> gameList, List<Game> games) {
        for(Object obj : gameList){
            Game game =(Game) obj;
            games.add(game);
        }
    }
}