package engine.charr;

import engine.error.exception.PlayerAttributesException;
import engine.game.Bag;
/**
 * Created by filipebraida on 31/05/16.
 * Edited by Alex, Pedro & Igor on Jan/2017
 */
public class Player extends Character {
    public Player(int life, int attack) {
        super(life, attack);
        attributes = new PlayerAttributes();
    }
    
    public Player(int id) {
    	super(10,10);
    	setupBag(10);
    	try {
			attributes = new PlayerAttributes(id);
		} catch (PlayerAttributesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void setupBag(int maxWeight) {
    	this.bag = new Bag(maxWeight);
    }
    
    public void newBag(int maxWeight) {
    	this.getBag().setMaxWeight(maxWeight);
    }
    
    public Bag getBag() {
    	return this.bag;
    }
    
    private Bag bag;
}
