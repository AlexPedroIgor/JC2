package engine.event;

import java.util.ArrayList;
import java.util.Collection;

import engine.charr.Character;

/**
 * Created by filipebraida on 31/05/16.
 * Edited by Pedro da Luz on Feb/2016.
 */
public abstract class Event {
    public Event(String description, Collection<Choice> choices) {
        this.description = description;
        this.choices = new ArrayList<>();

        int i = 0;
        for(Choice choice:choices) {
            choice.defineNumber(i);
            this.choices.add(choice);
            i++;
        }

    }

    public String history() {
        return this.description;
    }

    public boolean isEndEvent() {
        if(this.choices.isEmpty()) return true;

        return false;
    }

    public Collection<Choice> nextEvents() {
        return this.choices;
    }

    public Choice findChoice(int number) {
        for(Choice choice:this.choices) {
            if(choice.getNumber() == number) return choice;
        }

        return null;
    }

    public abstract void applyHistory(Character character);

    private String description;
    private Collection<Choice> choices;
}
