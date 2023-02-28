package it.gameXample.assets.players;

public class Player {
    protected String name;
    protected double hp;
    protected double stamina;
    protected String type;

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.stamina = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        if(type != null) {
            return "Nome: " + name + "\nHP: " + hp + "\nStamina: " + stamina + "\nTipo: " + type;
        }
        return "Nome: " + name + "\nHP: " + hp + "\nStamina: " + stamina;
    }
}
