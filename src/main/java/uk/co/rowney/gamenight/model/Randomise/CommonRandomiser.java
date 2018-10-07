package uk.co.rowney.gamenight.model.Randomise;

import uk.co.rowney.gamenight.model.JsonParser;
import uk.co.rowney.gamenight.objects.Game;
import uk.co.rowney.gamenight.objects.GameMode;

import java.util.List;

public class CommonRandomiser {

    private JsonParser jsonParser = new JsonParser();

    int getRandomForList(int listLength) {
        return (int) (Math.random() * listLength);
    }

}