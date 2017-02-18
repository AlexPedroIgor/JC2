package engine.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import engine.error.exception.EquipmentReadFileException;
import engine.error.exception.ItemReadFileException;
/**
 * Created by Alex, Pedro & Igor on Feb/2017.
 */
public class Equipment extends Item {
	public Equipment(int id) throws IOException {
		try {
			setup(id);
		} catch (ItemReadFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			setupEquipment(id);
		} catch (EquipmentReadFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void setupEquipment(int id) throws EquipmentReadFileException {
		try {
			String gamePath = System.getProperty("user.dir");
			String dataPath = gamePath + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "item";
			String equipmentsFile = dataPath + System.getProperty("file.separator") + "equipments.csv";
			
			BufferedReader readEquipmentsFile = new BufferedReader(
					new InputStreamReader(new FileInputStream(equipmentsFile), "UTF-8"));
			
			String line = readEquipmentsFile.readLine(); // First line doesn't count
			int currentID;
			int strength;
			int intelligence;
			int agility;
			int stamina;
			int spirit;
			int social;
			int perception;
			int sanity;
			int luck;
			
			do {
				line = readEquipmentsFile.readLine();
				currentID = new Integer(line.split(";")[0]);
				strength = new Integer(line.split(";")[2]);
				intelligence = new Integer(line.split(";")[3]);
				agility = new Integer(line.split(";")[4]);
				stamina = new Integer(line.split(";")[5]);
				spirit = new Integer(line.split(";")[6]);
				social = new Integer(line.split(";")[7]);
				perception = new Integer(line.split(";")[8]);
				sanity = new Integer(line.split(";")[9]);
				luck = new Integer(line.split(";")[10]);
			} while(currentID != id);
			readEquipmentsFile.close();
			
			setStrength(strength);
			setIntelligence(intelligence);
			setAgility(agility);
			setStamina(stamina);
			setSpirit(spirit);
			setSocial(social);
			setPerception(perception);
			setSanity(sanity);
			setLuck(luck);
		} catch(IOException e) {
			throw new EquipmentReadFileException();
		}
	}
	
	protected void setup(int id) throws ItemReadFileException {
		try {
			String gamePath = System.getProperty("user.dir");
			String dataPath = gamePath + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "item";
			String itensFile = dataPath + System.getProperty("file.separator") + "itens.csv";
			
			BufferedReader readItensFile = new BufferedReader(
					new InputStreamReader(new FileInputStream(itensFile), "UTF-8"));
			
			String line = readItensFile.readLine(); // First line doesn't count
			int currentID;
			String name;
			double price;
			double weight;
			int item_id;
			
			do {
				line = readItensFile.readLine();
				currentID = new Integer(line.split(";")[4]);
				name = new String(line.split(";")[1]);
				price = new Double(line.split(";")[2]);
				weight = new Double(line.split(";")[3]);
				item_id = new Integer(line.split(";")[0]);
			} while(currentID != id);
			readItensFile.close();
			
			setName(name);
			setPrice(price);
			setWeight(weight);
			setEquipment_id(id);
			setItem_id(item_id);
		} catch(IOException e) {
			throw new ItemReadFileException();
		}
	}
	
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

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
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
	
	public int getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}

	private int strength;
	private int intelligence;
	private int agility;
	private int stamina;
	private int spirit;
	private int social;
	private int perception;
	private int sanity;
	private int luck;
	
	private int equipment_id;
}
