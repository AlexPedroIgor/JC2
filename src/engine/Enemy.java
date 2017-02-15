package engine;
//JAVA LIBRARY
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// INTERNAL LIBRARY
import game.EnemyAttributes;
/**
 * Created by filipebraida on 31/05/16.
 * Edited by Alex, Pedro & Igor on Jan/2017
 */
public class Enemy extends Character {
    public Enemy(int life, int attack) {
        super(life, attack);
        attributes = new EnemyAttributes();
    }
    
    public Enemy(int id) throws IOException {
    	attributes = new EnemyAttributes(id);
    	setName(id);
    }
    
    public void setName(int id) throws IOException {
		String gamePath = System.getProperty("user.dir");
		String dataPath = gamePath + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "character";
		String enemyFile = dataPath + System.getProperty("file.separator") + "enemy.csv";
		
		BufferedReader readEnemyFile = new BufferedReader(
				new InputStreamReader(new FileInputStream(enemyFile), "UTF-8"));
		
		String line = readEnemyFile.readLine(); // First line doesn't count
		int currentID;
		String name;
		
		do {
			line = readEnemyFile.readLine();
			currentID = new Integer(line.split(";")[0]);
			name = line.split(";")[1];
		} while(currentID != id);
		readEnemyFile.close();
		
		setName(name);
	}
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private String name;
}
