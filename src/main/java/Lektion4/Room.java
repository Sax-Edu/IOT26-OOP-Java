package Lektion4;

import java.util.ArrayList;

public class Room {
    public String name;
    public double sqm;
    public ArrayList<Window> windows;

    public Room() {
        this.windows = new ArrayList<>();
    }

    public Room(String name, double sqm){
        this.name = name;
        this.sqm = sqm;
        this.windows = new ArrayList<>();
    }

}
