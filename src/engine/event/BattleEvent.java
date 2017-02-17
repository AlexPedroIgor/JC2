package engine.event;

import java.util.Collection;

import engine.Character;

public class BattleEvent extends Event {

	public BattleEvent(String description, Collection<Choice> choices) {
		super(description, choices);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyHistory(Character character) {
		// TODO Auto-generated method stub
		
	}

}
