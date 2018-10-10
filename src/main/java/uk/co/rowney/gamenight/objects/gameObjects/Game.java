package uk.co.rowney.gamenight.objects.gameObjects;

import java.util.List;

public class Game {

    private String name;
    private List<GameMode> gameModes;
    private boolean teamModes;
    private boolean ffaModes;

    //Getters
    public String getName() {
        return name;
    }

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    public boolean hasTeamModes() {
        return teamModes;
    }

    public boolean hasFfaModes() {
        return ffaModes;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGameModes(List<GameMode> gameModes) {
        this.gameModes = gameModes;
    }

    public void setTeamModes(boolean teamModes) {
        this.teamModes = teamModes;
    }

    public void setFfaModes(boolean ffaModes) {
        this.ffaModes = ffaModes;
    }
}
