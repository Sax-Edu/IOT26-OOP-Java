package Lektion4;

public class Pokemon {
    private String name;
    private Type type;
    private int maxHP;
    private int currentHP;

    public Pokemon (String name, Type type, int maxHP){
        this.name = name;
        this.type = type;
        this.maxHP = maxHP;
        this.currentHP =maxHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public String getName(){
        return name;
    }

    public Type getType(){
        return type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int currentHP) {
        if (currentHP < 0)      currentHP = 0;          // aldrig under noll
        if (currentHP > maxHP)  currentHP = maxHP;      // aldrig över max
        this.currentHP = currentHP;

    }
}
