package uk.co.rowney.gamenight.objects.tableObjects;

import static java.lang.String.format;

public class Player {

    private int id;
    private String name;
    private int score;

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString(){
        return format("ID: %s, Name: %s, Score: %s", this.id, this.name, this.score);
    }
}
