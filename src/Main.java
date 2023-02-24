import it.gameXample.boards.Greenland;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner userInput = new Scanner(System.in);

        Greenland board = new Greenland(System.in, System.out);
        board.startGame();
    }
}
