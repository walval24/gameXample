package it.gameXample.assets.equipment;

import it.gameXample.assets.enums.Type;

public class Weapon {
    protected String name;
    protected int damage;

    protected Type type;

    public Weapon(String name) {
        this.name = name;
        damage = 5;
        type = Type.GENERIC;
    }

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        type = Type.GENERIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
