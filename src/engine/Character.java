package engine;
// INTERNAL LIBRARY
import game.Attributes;
/**
 * Created by filipebraida on 31/05/16.
 * Edited by Alex, Pedro & Igor on Jan/2017
 */
public abstract class Character {

    public Character(int life, int attack) {
        this.life = life;
        this.attack = attack;
    }
    
    public Character() {
    	
    }

    public void battle(Character enemy) {
        this.takeDamage(enemy.getAttack());
        enemy.takeDamage(this.getAttack());
    }

    public boolean isAlive() {
        if(this.life > 0)
            return true;

        return false;
    }

    public void takeDamage(int attack) {
        this.life -= attack;
    }

    public int getAttack() {
        return this.attack;
    }
    
    public Attributes getAttributes() {
    	return this.attributes;
    }
    
    public void setAttributes(Attributes attributes) {
    	this.attributes = attributes;
    }
    
    protected Attributes attributes;

    private int life;
    private int attack;
}
