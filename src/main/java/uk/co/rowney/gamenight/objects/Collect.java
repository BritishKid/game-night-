package uk.co.rowney.gamenight.objects;

import java.util.ArrayList;
import java.util.List;

public class Collect<T> {

    List<T> list = new ArrayList<T>();
    public Collect(){

    }
    public void populate(T t){
        list.add(t);
    }
}
