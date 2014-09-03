package me.helloworm.example.model;

import java.util.ArrayList;
import java.util.List;

public class Worm {

    private final String name;
    private final List<Weapon> weapons;
    private int xp;

    public Worm(String name) {
        this.name = name;
        this.weapons = new ArrayList<>();
        xp = 0;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon findWeaponByName(String name) {
        for (Weapon weapon : getWeapons()) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        return null;
    }

    public void kill(Worm worm) {
        // some sort of algorithm that gives xp points
    }

    public int getXp() {
        return xp;
    }

}
