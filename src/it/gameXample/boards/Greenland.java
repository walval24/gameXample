package it.gameXample.boards;

import it.gameXample.assets.players.Player;
import it.gameXample.assets.players.WarriorPlayer;
import it.gameXample.assets.players.WizardPlayer;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Greenland {

    private static final String SEPARATOR = "--------------------";

    private static final int GO_AHEAD = 1;
    private static final int GO_RIGHT = 2;
    private static final int GO_LEFT = 3;
    private static final int PLAYER_DETAILS = 4;
    private static final int EXIT_GAME = 0;

    private Scanner input;      // Per ricevere l'input dell'utente
    private PrintStream ui;     // Per stampare a video

    private Player player;      // Creo un campo di tipo "Player" (generico

    public Greenland(InputStream inputStream, PrintStream ui) {
        this.input = new Scanner(inputStream);
        this.ui = ui;
    }

    public void startGame() {
        ui.println("Benvenuto nella prateria!");        //System.out.println("Benvenuto ...")
        printSeparator();
        createPlayer();
        printSeparator();
        ui.println(player);
        printSeparator();
        // Sessione di gioco
        boolean exit = false;
        do {
            int answer = askQuestion();
            switch (answer) {
                case GO_AHEAD:
                    ui.println("Sei andato avanti");
                    break;
                case GO_RIGHT:
                    ui.println("Sei andato a destra");
                    break;
                case GO_LEFT:
                    ui.println("Sei andato a sinistra");
                    break;
                case PLAYER_DETAILS:
                    ui.println(player);
                    break;
                case EXIT_GAME:
                    ui.println("Sei uscito dal gioco");
                    exit = true;
                    break;
                default:
                    ui.println("Il comando " + answer + " non è valido");
            }
            printSeparator();
        }while(!exit);
        ui.println("Grazie per aver giocato " + player.getName() + "!");

    }

    private void printSeparator() {
        ui.println(SEPARATOR);
    }

    private void createPlayer() {
        if(player == null) {                        // Se ho appena iniziato il player è null
            ui.print("Come ti chiami ? - ");
            String playerName = input.nextLine();
            ui.println("Scegli il tipo: ");
            ui.println("[1] - Generico");
            ui.println("[2] - Guerriero");
            ui.println("[3] - Mago");
            ui.print("Risposta: ");
            int choice = input.nextInt();
            if(choice == 1) {
                player = new Player(playerName);
            }
            else if(choice == 2) {
                player = new WarriorPlayer(playerName);
            }
            else if(choice == 3) {
                player = new WizardPlayer(playerName);
            }
            else {
                player = new Player(playerName);
            }
        }
        else {                                      // Se sono già in sessione il player esiste
            if(player.getHp() == 0) {               // Se ha gli hp = 0 allora lo faccio rivivere
                player.setHp(100);
                player.setStamina(50);
            }
        }
    }

    private int askQuestion() {
        ui.println("Cosa vuoi fare ? ");
        ui.println("[" + GO_AHEAD + "] - Vai avanti");
        ui.println("[" + GO_RIGHT +"] - Vai a destra");
        ui.println("[" + GO_LEFT + "] - Vai a sinistra");
        ui.println("["+ PLAYER_DETAILS +"] - Dettagli personaggio");
        ui.println("["+ EXIT_GAME + "] - Esci");

        ui.print("Risposta: ");
        return input.nextInt();
    }
}
