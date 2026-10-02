package Lektion4;

public class Window {

    public String name;
    public String color;
    public boolean openable;

    public Window(){}



    @Override
    public String toString(){
        return name + ", färg: " +color +".";
    }
}
