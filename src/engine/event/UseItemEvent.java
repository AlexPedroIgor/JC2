package engine.event;

import java.util.ArrayList;

import engine.charr.Character;
import engine.game.Effect;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class UseItemEvent extends Event {

	public UseItemEvent(String description, Effect itemEffect) {
		super(description, new ArrayList<Choice>());
		this.effect = itemEffect;
	}

	@Override
	public void applyHistory(Character character) {
		effect.applyEffect(character);
	}
	
	private Effect effect;
}
