package it.gameXample.boards;

import it.gameXample.assets.enemies.Enemy;

public class EnemyGenerator {

    public static Enemy[] generateEnemies() {
        return new Enemy[] {
                new Enemy("Babbala"),
                new Enemy("Pierino"),
                new Enemy("Pacciani"),
                new Enemy("Berlusconi"),
                new Enemy("Antonello Venditti")
        };
    }
}
