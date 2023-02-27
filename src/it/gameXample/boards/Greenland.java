package it.gameXample.boards;
import it.gameXample.assets.players.Player;
import it.gameXample.assets.players.WarriorPlayer;

import java.io.PrintStream;
import java.util.Scanner;

public class Greenland {
    private static final String SEPARATOR = "------------------";
    private static final int GO_AHEAD = 1;
    private static final int GO_RIGHT = 2;
    private static final int GO_LEFT = 3;
    private static final int PLAYER_DETAILS = 4;
    private static final int EXIT_GAME = 0;



    private Scanner input; // per ricevere l'input dell'utente
    private PrintStream UI;
    private Player player;

    public Greenland(Scanner input, PrintStream UI) {
        this.input = input;
        this.UI = UI;
    }

    public void startGame() {
        UI.println("Benvenuto nella prateria!");
        printSeparator();
        createPlayer();
        printSeparator();
        UI.println(player);
        printSeparator();

        boolean exit = false;
        do{
            int answer = askQuestion();
            switch (answer){
                case GO_AHEAD:
                    UI.println("Sei andato avanti");
                    break;
                case GO_RIGHT:
                    UI.println("Sei andato a destra");
                    break;
                case GO_LEFT:
                    UI.println("Sei andato a sinistra");
                    break;
                case PLAYER_DETAILS:
                    UI.println(player);
                    break;
                case EXIT_GAME:
                    UI.println("Sei uscito dal gioco");
                    exit = true;
                    break;
                default:
                    UI.println("Il comando " + answer + " non e' valido");

            }
            printSeparator();
        }while (!exit);
        UI.println("Grazie per aver giocato " + player.getName() + "!");

    }

    private void printSeparator() {
        UI.println(SEPARATOR);
    }

    private void createPlayer() {
        if (player == null) {
            UI.println("Come ti chiami ? - ");
            String playerName = input.nextLine();
            UI.println("Scegli il tipo");
            UI.println("[1] - Generico");
            UI.println("[2] - Guerriero");
            UI.println("Risposta: ");
            int choice = input.nextInt();
            if(choice == 1){
                player = new Player(playerName);
            }
            else if(choice == 2) {
                player = new WarriorPlayer(playerName);
            }
            else {
                player = new Player(playerName);
            }

        } else {
            if (player.getHp() == 0) {
                player.setHp(100);
                player.setStamina(50);

            }
        }


    }
    private int askQuestion() {
        UI.println("Cosa vuoi fare ? ");
        UI.println("[1] - Vai avanti");
        UI.println("[2] - Vai a destra");
        UI.println("[3] - Vai a sinistra");
        UI.println("[4] - Dettagli personaggio");
        UI.println("[0] - Esci");

        UI.print ("Risposta: ");
        return input.nextInt();

    }
}
