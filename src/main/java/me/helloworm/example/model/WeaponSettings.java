package me.helloworm.example.model;

public class WeaponSettings {

    private final Weapon weapon;
    private final GenericSettings settings;

    public WeaponSettings(Weapon weapon, GenericSettings settings) {
        this.weapon = weapon;
        this.settings = settings;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean areValidFor(Worm worm) {
        return worm.getXp() >= weapon.getRequiredXp() && settings.areValid();
    }
}
