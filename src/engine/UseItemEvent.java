package engine;

import java.util.Collection;

public class UseItemEvent extends Event {

	public UseItemEvent(String description, Collection<Choice> choices) {
		super(description, choices);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyHistory(Character character) {
		// TODO Auto-generated method stub
		
	}

}
