package it.gameXample.assets.players;

import it.gameXample.assets.Character;
import it.gameXample.assets.enemies.Enemy;
import it.gameXample.assets.enums.Type;
import it.gameXample.assets.equipments.Weapon;
import it.gameXample.assets.interfaces.Striker;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Player extends Character implements Striker {
    protected Type type;
    protected Weapon weapon;

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.stamina = 50;
        damage = 10;
        resistance = 10;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        if(this.type == weapon.getType()) {
            this.weapon = weapon;
        }
    }

    public String toString() {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina: " + stamina;
    }

    @Override
    protected double calculateDamage() {
        int randomNr = ThreadLocalRandom.current().nextInt(1, 101);
        double critDamage = 0;
        if(randomNr <= 30) {
            critDamage = damage * 1.2;
        }

        if(weapon != null) {
            return damage + weapon.getDamage() + critDamage;
        }
        return damage + critDamage;
    }

    @Override
    public void attack(Character enemy) {
        double playerDamage = calculateDamage();
        double totalDamage = playerDamage - enemy.getResistance();

        double enemyHp = enemy.getHp();

        enemy.setHp(enemyHp - totalDamage);
    }
}
