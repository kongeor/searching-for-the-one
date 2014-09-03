package me.helloworm.example.model;

public class Weapon {

    private final String name;
    private final int requiredXp;
    private final Map map;

    public Weapon(String name, int requiredXp, Map map) {
        this.name = name;
        this.requiredXp = requiredXp;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public int getRequiredXp() {
        return requiredXp;
    }

    public Map getMap() {
        return map;
    }

}
