package it.gameXample.boards;

import it.gameXample.assets.Player;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Greenland {

    private static final String SEPARATOR = "----------------------";
    private static final int GO_AHEAD = 1;
    private static final int GO_RIGHT = 2;
    private static final int GO_LEFT = 3;
    private static final int PLAYER_DETAILS = 4;

    private static final int EXIT_GAME = 0;

    private Scanner input;
    private PrintStream ui;

    private Player player;

    public Greenland(InputStream inputStream, PrintStream ui){
        this.input = new Scanner(inputStream);
        this.ui = ui;
    }
    public void startGame() {
        ui.println("Benvenuto nella prateria!");
        printSeparator();
        createPlayer();
        printSeparator();
        ui.println(player);
        printSeparator();

        boolean exit = false;
        do {
            int answer = askQuestion();
            switch (answer){
                case GO_AHEAD:
                    ui.println("Sei andato avanti");
                    break;
                case GO_RIGHT:
                    ui.println("Sei andato destro");
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

        }while (!exit);
ui.println("Grazie per aver giocato " + player.getName() + "!");
    }


    private void printSeparator() {
        ui.println(SEPARATOR);
    }

    private void createPlayer(){
        if(player == null){
            ui.print("Come ti chiami ? - ");
            String playerName = input.nextLine();
            player = new Player(playerName);
        }
        else {
            if(player.getHp() == 0){
                player.setHp(100);
                player.setStamina(50);
            }
        }
    }

    private int askQuestion(){
        ui.println("Cosa vuoi fare ? ");
        ui.println("[1] - Vai avanti");
        ui.println("[2] - Vai destra");
        ui.println("[3] - Vai sinistra");
        ui.println("[4] - Dettagli personaggio");
        ui.println("[0] - Esci");

        ui.print("Risposta: ");
        return input.nextInt();
    }

}
