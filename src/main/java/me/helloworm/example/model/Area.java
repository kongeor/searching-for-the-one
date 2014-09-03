package me.helloworm.example.model;

import java.util.List;

public class Area {

    private List<WeaponSettings> settings;

    public WeaponSettings getWeaponSettingsFor(String weaponName) {
        for (WeaponSettings setting : settings) {
            if (setting.getWeapon().getName().equals(weaponName))
                return setting;
        }
        return null;
    }

    public boolean isLocatedIn(Worm worm) {
        // some algorthim
        return true;
    }
}
