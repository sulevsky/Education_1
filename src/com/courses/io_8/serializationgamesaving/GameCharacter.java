package com.courses.io_8.serializationgamesaving;


import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by VSulevskiy on 17.07.2015.
 */
public class GameCharacter implements Serializable {
    private int power;
    private String name;
    private CharacterType type;
    transient private String[] weapons;

    public GameCharacter(int power, String name, CharacterType type, String[] weapons) {
        this.power = power;
        this.name = name;
        this.type = type;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "power=" + power +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", weapons=" + Arrays.toString(weapons) +
                '}';
    }
}
