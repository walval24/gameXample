package it.gameXample.assets.enums;

import it.gameXample.assets.players.Player;
import it.gameXample.assets.players.WarriorPlayer;
import it.gameXample.assets.players.WizardPlayer;

public enum Type {
    WARRIOR(1), WIZARD(2);

    protected int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Player getPlayer(int value, String name) {
        switch (value) {
            case 1:
                return new WarriorPlayer(name);
            case 2:
                return new WizardPlayer(name);
        }
        return null;
    }
}
