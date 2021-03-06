package engine.charr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import engine.error.exception.PlayerAttributesException;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class PlayerAttributes extends Attributes {
	public PlayerAttributes() {
		super();
	}
	
	public PlayerAttributes(int id) throws PlayerAttributesException {
		try {
			setAttributes(id);
		} catch (IOException e) {
			throw new PlayerAttributesException();
		}
	}
	
	protected void setAttributes(int id) throws IOException {
		String gamePath = System.getProperty("user.dir");
		String dataPath = gamePath + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "character";
		String playerPath = dataPath + System.getProperty("file.separator") + "enemy.csv";
		
		BufferedReader readPlayerFile = new BufferedReader(
				new InputStreamReader(new FileInputStream(playerPath), "UTF-8"));
		
		String line = readPlayerFile.readLine(); // First line doesn't count
		int currentID;
		int strength;
		int intelligence;
		int agility;
		int stamina;
		int spirit;
		int social;
		
		do {
			line = readPlayerFile.readLine();
			currentID = new Integer(line.split(";")[0]);
			strength = new Integer(line.split(";")[2]);
			intelligence = new Integer(line.split(";")[3]);
			agility = new Integer(line.split(";")[4]);
			stamina = new Integer(line.split(";")[5]);
			spirit = new Integer(line.split(";")[6]);
			social = new Integer(line.split(";")[7]);
		} while(currentID != id);
		readPlayerFile.close();
		
		setStrength(strength);
		setIntelligence(intelligence);
		setAgility(agility);
		setStamina(stamina);
		setSpirit(spirit);
		setSocial(social);
	}
	
	public int getSocial() {
		return social;
	}
	public void setSocial(int social) {
		this.social = social;
	}
	public int getSanity() {
		return sanity;
	}
	public void setSanity(int sanity) {
		this.sanity = sanity;
	}
	public int getLuck() {
		return luck;
	}
	public void setLuck(int luck) {
		this.luck = luck;
	}
	
	protected int social;
	protected int sanity;
	protected int luck;
}
