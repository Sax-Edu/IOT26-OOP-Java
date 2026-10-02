package Lektion4;

import java.util.ArrayList;

public class Lesson4Live {
    public static void main(String[] args) {

        Pokemon pikachu = new Pokemon("Pikachu", Type.GHOST, 100);

        //pikachu.name = "Pikachu";
        pikachu.setName("PIKACHU");

        //pikachu.type = Type.ELECTRIC;

        pikachu.setType(Type.ELECTRIC);

        System.out.println(pikachu.getName() +" is " +pikachu.getType());

        pikachu.setCurrentHP(9999);

        System.out.println(pikachu.getName() +" har currentHP: " +pikachu.getCurrentHP());
        /*
        Window northWindow = new Window();
        Window southWindow = new Window();

        northWindow.name = "Fönstret åt norr";
        northWindow.color="röd";
        northWindow.openable= true;

        southWindow.name = "Fönstret åt syd";
        southWindow.color="gul";
        southWindow.openable= false;

        ArrayList<Window> windowList = new ArrayList<>();

        windowList.add(northWindow);
        windowList.add(southWindow);

        for(Window win : windowList){
            System.out.println(win.name +" har färgen " + win.color);
        }

        Room livingRoom = new Room("Vardagsrum",12.5);

        livingRoom.windows.add(southWindow);

        System.out.println(livingRoom.name +" är " +livingRoom.sqm +" kvm stort och har " +livingRoom.windows.size() + " fönster.");


        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Anna");
        stringList.add("Bertil");

        System.out.println(stringList);

        System.out.println(windowList);

        System.out.println(northWindow.name +" har färgen " +northWindow.color);
        System.out.println(southWindow.name +" har färgen " +southWindow.color);*/

    }
}
