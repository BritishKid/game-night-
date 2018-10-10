package uk.co.rowney.gamenight.model;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import uk.co.rowney.gamenight.objects.gameObjects.Game;
import uk.co.rowney.gamenight.objects.gameObjects.Series;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import static java.lang.String.format;

public class JsonParser {

    private Gson gson = new Gson();
    private List<Game> gameList;

    public List<Series> getSeriesList() throws FileNotFoundException {
        Type REVIEW_TYPE = new TypeToken<List<Series>>() {}.getType();
        URL url = getClass().getResource("/json/lists/SeriesList.json");
        JsonReader reader = new JsonReader(new FileReader(url.getPath()));

        return gson.fromJson(reader, REVIEW_TYPE);
    }


    public List<Game> getGameList(String fileName) throws FileNotFoundException {
        Type REVIEW_TYPE = new TypeToken<List<Game>>() {}.getType();
        URL url = getClass().getResource(format("/json/games/%s.json", fileName));
        JsonReader reader = new JsonReader(new FileReader(url.getPath()));

        return gson.fromJson(reader, REVIEW_TYPE);
    }
}
