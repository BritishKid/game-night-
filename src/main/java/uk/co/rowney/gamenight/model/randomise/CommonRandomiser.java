package uk.co.rowney.gamenight.model.randomise;

import uk.co.rowney.gamenight.model.JsonParser;

public class CommonRandomiser {

    private JsonParser jsonParser = new JsonParser();

    int getRandomForList(int listLength) {
        return (int) (Math.random() * listLength);
    }

}