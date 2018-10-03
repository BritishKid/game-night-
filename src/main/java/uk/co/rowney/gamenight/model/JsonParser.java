package uk.co.rowney.gamenight.model;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.Series;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {

    private Gson gson = new Gson();
    private List<Game> gameList;

    public List<Series> getSeriesList() throws FileNotFoundException {
        Type REVIEW_TYPE = new TypeToken<List<Series>>() {}.getType();
        String filename =
                "C:\\Users\\Dell\\Documents\\Repo\\game-night\\src\\main\\resources\\json\\lists\\SeriesList.json";
        JsonReader reader = new JsonReader(new FileReader(filename));

        return gson.fromJson(reader, REVIEW_TYPE);
    }


    public List<Game> getGameList(String fileName) throws FileNotFoundException {
        Type REVIEW_TYPE = new TypeToken<List<Game>>() {}.getType();
        String filename =
                "C:\\Users\\Dell\\Documents\\Repo\\game-night\\src\\main\\resources\\json\\games\\" + fileName + ".json";
        JsonReader reader = new JsonReader(new FileReader(filename));

        return gson.fromJson(reader, REVIEW_TYPE);
    }
}
