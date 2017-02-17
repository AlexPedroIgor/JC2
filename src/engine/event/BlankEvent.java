package engine.event;
import java.util.Collection;

import engine.charr.Character;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BlankEvent extends Event{
    public BlankEvent(String description, Collection<Choice> choices) {
        super(description, choices);
    }

    @Override
    public void applyHistory(Character character) {

    }
}
