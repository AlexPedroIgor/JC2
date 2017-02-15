package engine;
// INTERNAL LIBRARY
import game.EnemyAttributes;
/**
 * Created by filipebraida on 31/05/16.
 * Edited by Alex, Pedro & Igor on Jan/2017
 */
public class Enemy extends Character {
    public Enemy(int life, int attack) {
        super(life, attack);
        attributes = new EnemyAttributes();
    }
}
