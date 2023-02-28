package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.players.Player;
import it.gameXample.assets.players.WarriorPlayer;
import it.gameXample.assets.players.WizardPlayer;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Greenland {

    private static final String SEPARATOR = "--------------------";


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
            Action moveAction = Command.createMoveAction(player);
            ui.print(moveAction);
        int choice = input.nextInt();
        ui.println(moveAction.getAnswer(choice));
        if(choice == 0) {
            exit = true;
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
           ui.print("Come ti chiami ? ");
           String playerName = input.nextLine();
           Action typeAction = Command.createPlayerTypeAction();
           ui.print(typeAction);
           int choice = input.nextInt();
           ui.println(typeAction.getAnswer(choice));

            switch (choice){
                case 1:
                    player = new Player(playerName);
                    break;
                case 2:
                    player = new WarriorPlayer(playerName);
                    break;
                case 3:
                    player = new WizardPlayer(playerName);
                    break;
                default:
                    player = new Player(playerName);
                    break;
            }
        }
        else {                                      // Se sono già in sessione il player esiste
            if(player.getHp() == 0) {               // Se ha gli hp = 0 allora lo faccio rivivere
                player.setHp(100);
                player.setStamina(50);
            }
        }
    }

}
