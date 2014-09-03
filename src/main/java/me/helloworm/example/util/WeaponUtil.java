package me.helloworm.example.util;

import me.helloworm.example.model.Area;
import me.helloworm.example.model.Map;
import me.helloworm.example.model.Weapon;
import me.helloworm.example.model.WeaponEquipmentResponse;
import me.helloworm.example.model.WeaponSettings;
import me.helloworm.example.model.Worm;

public class WeaponUtil {

    public WeaponEquipmentResponse equip(Worm worm, String weaponName) {

        WeaponEquipmentResponse response = WeaponEquipmentResponse.SUCCESS;

        Weapon weapon = worm.findWeaponByName(weaponName);

        if (weapon == null) {
            response = WeaponEquipmentResponse.WEAPON_NOT_FOUND;
        } else {
            Map map = weapon.getMap();
            if (map == null) {
                response = WeaponEquipmentResponse.MAP_NOT_ASSOCIATED_WITH_WEAPON;
            } else {
                Area area = map.getAreaFor(worm);
                if (area != null) {
                    WeaponSettings settings = area.getWeaponSettingsFor(weaponName);
                    if (settings != null) {
                        if (!settings.areValidFor(worm)) {
                            response = WeaponEquipmentResponse.WEAPON_SETTINGS_ARE_NOT_VALID;
                        }
                    }
                }
            }
        }

        return response;
    }
}
