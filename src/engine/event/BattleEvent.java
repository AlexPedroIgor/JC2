package engine.event;

import java.util.ArrayList;

import engine.charr.Character;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class BattleEvent extends Event {

	public BattleEvent(String description) {
		super(description, new ArrayList<Choice>());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyHistory(Character character) {
		// TODO Auto-generated method stub
		
	}

}
