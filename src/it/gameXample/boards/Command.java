package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.actions.Option;
import it.gameXample.assets.players.Player;

public class Command {

    public static Action createMoveAction(Player player){
        Option[] options = new Option[] {
          new Option(1,"Vai avanti","Sei andato avanti "),
          new Option(2,"Vai a destra","Sei andato a destra"),
          new Option(3,"Vai a sinistra","Sei andato a sinistra"),
          new Option(4,"Dettagli giocatore",player.toString()),
          new Option(0,"Esci","Sei uscito dal gioco")
        };
return new Action("cosa vuoi fare?", options);
}
    public static Action createPlayerTypeAction() {
        Option[] options = new Option[]{
                new Option(1,"Generico", "Hai scelto un generico personaggio"),
                new Option(2,"Guerriero", "Hai scelto il guerriero"),
                new Option(3,"Mago","Hai scelto il mago")
        };
        return new Action("Che ruolo vuoi avere ? ", options);
    }
}