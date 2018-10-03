package uk.co.rowney.gamenight.objects;

import java.util.List;

public class Game {

    private String name;
    private List<GameModes> gameModes;

    //Getters
    public String getName() {
        return name;
    }

    public List<GameModes> getGameModes() {
        return gameModes;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGameModes(List<GameModes> gameModes) {
        this.gameModes = gameModes;
    }
}
