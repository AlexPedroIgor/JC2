package engine.event;

import java.util.ArrayList;

import engine.charr.Character;
import engine.charr.Enemy;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class BattleEvent extends Event {

	public BattleEvent(String description, Enemy enemy) {
		super(description, new ArrayList<Choice>());
		this.enemy = enemy;
	}

	@Override
	public void applyHistory(Character character) {
		// TODO Auto-generated method stub
		
	}
	
	private Enemy enemy;
}
