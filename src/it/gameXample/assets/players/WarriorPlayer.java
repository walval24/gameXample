package it.gameXample.assets.players;

public class WarriorPlayer extends Player{

    protected String type;

    public WarriorPlayer(String name) {
        super(name);
        this.type = "Guerriero";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String details = super.toString();
        details += "\nTipo " + type;
        return details;

    }
}
