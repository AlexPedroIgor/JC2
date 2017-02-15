package engine;
// INTERNAL LIBRARY
import game.PlayerAttributes;
/**
 * Created by filipebraida on 31/05/16.
 * Edited by Alex, Pedro & Igor on Jan/2017
 */
public class Player extends Character {
    public Player(int life, int attack) {
        super(life, attack);
        attributes = new PlayerAttributes();
    }
}
