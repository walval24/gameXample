package it.gameXample.assets.enums;

import it.gameXample.assets.players.Player;
import it.gameXample.assets.players.WarriorPlayer;
import it.gameXample.assets.players.WizardPlayer;

public enum Type {

    GENERIC(1), WARRIOR(2), WIZARD(3);

    protected int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Player getPlayer(int value, String name){
        switch (value){
            case 1:
                return new Player(name);
            case 2:
                return new WarriorPlayer(name);
            case 3:
                return new WizardPlayer(name);
            default :
                return new Player(name);
        }
    }

}
