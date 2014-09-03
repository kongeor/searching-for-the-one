package me.helloworm.example.util;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.when;
import me.helloworm.example.model.Area;
import me.helloworm.example.model.Map;
import me.helloworm.example.model.Weapon;
import me.helloworm.example.model.WeaponEquipmentResponse;
import me.helloworm.example.model.WeaponSettings;
import me.helloworm.example.model.Worm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WeaponUtilTest {

    private @Mock Worm worm;
    private @Mock Weapon weapon;
    private @Mock Map map;
    private @Mock Area area;
    private @Mock WeaponSettings settings;
    private final String weaponName = "Axe";

    private WeaponUtil util;

    @Before
    public void setUp() {
        util = new WeaponUtil();
    }

    @Test
    public void worm_does_not_have_weapon() {
        assertThat(util.equip(worm, weaponName)).isEqualTo(WeaponEquipmentResponse.WEAPON_NOT_FOUND);
    }

    @Test
    public void worm_has_unmapped_weapon() {
        when(worm.findWeaponByName(weaponName)).thenReturn(weapon);
        assertThat(util.equip(worm, weaponName)).isEqualTo(WeaponEquipmentResponse.MAP_NOT_ASSOCIATED_WITH_WEAPON);
    }

    @Test
    public void no_map_areas_for_weapon() {
        when(worm.findWeaponByName(weaponName)).thenReturn(weapon);
        when(weapon.getMap()).thenReturn(map);
        assertThat(util.equip(worm, weaponName)).isEqualTo(WeaponEquipmentResponse.SUCCESS);
    }

    @Test
    public void map_area_without_settings() {
        when(worm.findWeaponByName(weaponName)).thenReturn(weapon);
        when(weapon.getMap()).thenReturn(map);
        when(map.getAreaFor(worm)).thenReturn(area);
        assertThat(util.equip(worm, weaponName)).isEqualTo(WeaponEquipmentResponse.SUCCESS);
    }

    @Test
    public void invalid_map_settings_for_weapon() {
        when(worm.findWeaponByName(weaponName)).thenReturn(weapon);
        when(weapon.getMap()).thenReturn(map);
        when(map.getAreaFor(worm)).thenReturn(area);
        when(area.getWeaponSettingsFor(weaponName)).thenReturn(settings);
        assertThat(util.equip(worm, weaponName)).isEqualTo(WeaponEquipmentResponse.WEAPON_SETTINGS_ARE_NOT_VALID);
    }

    @Test
    public void valid_map_settings_for_weapon() {
        when(worm.findWeaponByName(weaponName)).thenReturn(weapon);
        when(weapon.getMap()).thenReturn(map);
        when(map.getAreaFor(worm)).thenReturn(area);
        when(area.getWeaponSettingsFor(weaponName)).thenReturn(settings);
        when(settings.areValidFor(worm)).thenReturn(true);
        assertThat(util.equip(worm, weaponName)).isEqualTo(WeaponEquipmentResponse.SUCCESS);
    }
}
