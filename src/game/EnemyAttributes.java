package game;
// JAVA LIBRARY
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Alex, Pedro & Igor on Jan/2017.
 */
public class EnemyAttributes extends Attributes {
	public EnemyAttributes() {
		super();
	}
	
	public EnemyAttributes(int id) throws IOException {
		setAttributes(id);
	}
	
	public void setAttributes(int id) throws IOException {
		String gamePath = System.getProperty("user.dir");
		String dataPath = gamePath + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "character";
		String enemyFile = dataPath + System.getProperty("file.separator") + "enemy.csv";
		
		BufferedReader readEnemyFile = new BufferedReader(
				new InputStreamReader(new FileInputStream(enemyFile), "UTF-8"));
		
		String line = readEnemyFile.readLine(); // First line doesn't count
		int currentID;
		int strength;
		int intelligence;
		int agility;
		int stamina;
		int spirit;
		int perception;
		
		do {
			line = readEnemyFile.readLine();
			currentID = new Integer(line.split(";")[0]);
			strength = new Integer(line.split(";")[2]);
			intelligence = new Integer(line.split(";")[3]);
			agility = new Integer(line.split(";")[4]);
			stamina = new Integer(line.split(";")[5]);
			spirit = new Integer(line.split(";")[6]);
			perception = new Integer(line.split(";")[7]);
		} while(currentID != id);
		readEnemyFile.close();
		
		setStrength(strength);
		setIntelligence(intelligence);
		setAgility(agility);
		setStamina(stamina);
		setSpirit(spirit);
		setPerception(perception);
	}
}
