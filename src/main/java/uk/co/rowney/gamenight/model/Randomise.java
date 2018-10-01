package uk.co.rowney.gamenight.model;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import uk.co.rowney.gamenight.objects.Game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

public class Randomise {
    public String randomGame() throws FileNotFoundException {
        List<Game> gameList = getGameList();
        Game game = getGameFromList(gameList);

        return game.getName();
    }

    private Game getGameFromList(List<Game> gameList) {
        int randomNumber =  (int) (Math.random() * gameList.size());
        return  gameList.get(randomNumber);

    }

    private List<Game> getGameList() throws FileNotFoundException {

        Type REVIEW_TYPE = new TypeToken<List<Game>>() {}.getType();
        Gson gson = new Gson();
        String filename = "C:\\Users\\Dell\\Documents\\Repo\\game-night\\src\\main\\resources\\json\\GameList.json";
        JsonReader reader = new JsonReader(new FileReader(filename));
        List<Game> gameList = gson.fromJson(reader, REVIEW_TYPE);

        return gameList;
    }
}