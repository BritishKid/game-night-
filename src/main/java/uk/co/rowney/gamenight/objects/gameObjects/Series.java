package uk.co.rowney.gamenight.objects.gameObjects;

public class Series {

    private int id;
    private String name;
    private String fileName;
    private boolean teamModes;
    private boolean ffaModes;

    //getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean hasTeamModes() {
        return teamModes;
    }

    public boolean hasFfaModes() {
        return ffaModes;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTeamModes(boolean teamModes) {
        this.teamModes = teamModes;
    }

    public void setFfaModes(boolean ffaModes) {
        this.ffaModes = ffaModes;
    }
}
