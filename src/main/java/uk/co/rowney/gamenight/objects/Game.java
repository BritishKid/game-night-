package uk.co.rowney.gamenight.objects;

import java.util.List;

public class Game {

    private String name;
    private List<GameMode> gameModes;

    //Getters
    public String getName() {
        return name;
    }

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGameModes(List<GameMode> gameModes) {
        this.gameModes = gameModes;
    }
}
