package it.gameXample.boards;

import it.gameXample.assets.actions.Action;
import it.gameXample.assets.enemies.Enemy;
import it.gameXample.assets.players.Player;
import it.gameXample.assets.enums.Type;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Greenland {

    private static final String SEPARATOR = "--------------------";


    private Scanner input;      // Per ricevere l'input dell'utente
    private PrintStream ui;     // Per stampare a video

    private Player player;      // Creo un campo di tipo "Player" generico

    private Enemy[] enemies;

    public Greenland(InputStream inputStream, PrintStream ui) {
        this.input = new Scanner(inputStream);
        this.ui = ui;

        enemies = EnemyGenerator.generateEnemies();
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
            if (choice == 0) {
                exit = true;
            } else if ( choice != 4) {
                searchEnemy();

            }

            printSeparator();
        } while (!exit);
        ui.println("Grazie per aver giocato " + player.getName() + "!");

    }

    private void printSeparator() {
        ui.println(SEPARATOR);
    }

    private void createPlayer() {
        if (player == null) {                        // Se ho appena iniziato il player è null
            ui.print("Come ti chiami ? ");
            String playerName = input.nextLine();
            Action typeAction = Command.createPlayerTypeAction();
            ui.print(typeAction);
            int choice = input.nextInt();
            ui.println(typeAction.getAnswer(choice));

            player = Type.getPlayer(choice, playerName);

        } else {                                      // Se sono già in sessione il player esiste
            if (player.getHp() == 0) {               // Se ha gli hp = 0 allora lo faccio rivivere
                player.setHp(100);
                player.setStamina(50);
            }
        }
    }

    private void searchEnemy() {
        int randomNr = ThreadLocalRandom.current().nextInt(1, 101);
        if (randomNr < 80) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, enemies.length);
            Enemy enconteredEnemy = enemies[randomIndex];
            ui.println("Ti sei imbattuto in un : " + enconteredEnemy.getName());
            Action attackAction = Command.createAttackAction();
            do {
                ui.print(attackAction);
                int choice = input.nextInt();
                ui.println(attackAction.getAnswer(choice));
                if(choice == 1){
                    fightEnemy(enconteredEnemy);
                }
            }while(enconteredEnemy.getHp() > 0);

        }
    }

    private void fightEnemy(Enemy enemy) {
        player.attackEnemy(enemy);
        ui.println(enemy);
        printSeparator();
    }
}

