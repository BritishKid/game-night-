package uk.co.rowney.gamenight.objects;

public class GameModes {

    private String name;
    private boolean team = false;
    private boolean ffa = false;

    //Getters
    public String getName() {
        return name;
    }

    public boolean isTeam() {
        return team;
    }

    public boolean isFfa() {
        return ffa;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(boolean team) {
        this.team = team;
    }

    public void setFfa(boolean ffa) {
        this.ffa = ffa;
    }
}
