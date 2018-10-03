package uk.co.rowney.gamenight.objects;

public class Series {

    private int id;
    private String name;
    private String fileName;

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
}
