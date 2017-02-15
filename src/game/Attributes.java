package game;
// JAVA LIBRARY
import java.io.IOException;
/**
 * Created by Alex, Pedro & Igor on Jan/2017.
 */
public abstract class Attributes {
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getSpirit() {
		return spirit;
	}
	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}
	public int getPerception() {
		return perception;
	}
	public void setPerception(int perception) {
		this.perception = perception;
	}
	
	public abstract void setAttributes(int id) throws IOException;
	
	private int strength;
	private int intelligence;
	private int agility;
	private int stamina;
	private int spirit;
	private int perception;
}
