package uk.co.rowney.gamenight.model.filter;

import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.GameMode;
import uk.co.rowney.gamenight.objects.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameModeFilter implements Filter{

    private List<GameMode> filteredList = new ArrayList<>();

    @Override
    public List listWithTeam(List<?> gameModeList) {
        List<GameMode> gameModes =  new ArrayList<>();

        castLisToGameMode(gameModeList, gameModes);

        filteredList = gameModes.stream()
                .filter(GameMode::isTeam)
                .collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List listWithFfa(List<?> gameModeList) {
        List<GameMode> gameModes =  new ArrayList<>();

        castLisToGameMode(gameModeList, gameModes);

        filteredList = gameModes.stream()
                .filter(GameMode::isFfa)
                .collect(Collectors.toList());
        return filteredList;
    }

    private void castLisToGameMode(List<?> gameModeList, List<GameMode> gameModes) {
        for (Object obj : gameModeList) {
            GameMode gameMode = (GameMode) obj;
            gameModes.add(gameMode);
        }
    }
}
