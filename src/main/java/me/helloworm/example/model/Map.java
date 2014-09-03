package me.helloworm.example.model;

import java.util.List;

public class Map {

    private List<Weapon> associatedWeapons;
    private List<Area> areas;

    public Area getAreaFor(Worm worm) {
        for (Area area : areas) {
            if (area.isLocatedIn(worm))
                return area;
        }
        return null;
    }
}
