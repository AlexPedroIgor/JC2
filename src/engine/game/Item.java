package engine.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import engine.error.exception.ItemReadFileException;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class Item {
	public Item(int id) {
		try {
			setup(id);
		} catch(ItemReadFileException e) {
			e.printStackTrace();
		}
	}
	
	public Item() {
		// Do nothing
	}
	
	private void setup(int id) throws ItemReadFileException {
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
			int equipment_id;
			
			do {
				line = readItensFile.readLine();
				currentID = new Integer(line.split(";")[0]);
				name = new String(line.split(";")[1]);
				price = new Double(line.split(";")[2]);
				weight = new Double(line.split(";")[3]);
				equipment_id = new Integer(line.split(";")[4]);
			} while(currentID != id);
			readItensFile.close();
			
			setName(name);
			setPrice(price);
			setWeight(weight);
			setEquipment_id(equipment_id);
		} catch(IOException e) {
			throw new ItemReadFileException();
		}
	}
	
	protected void setupEq(int id) throws ItemReadFileException {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
		
	public Effect getItemEffect() {
		return itemEffect;
	}

	public void setItemEffect(Effect itemEffect) {
		this.itemEffect = itemEffect;
	}

	protected Effect itemEffect;

	protected String name;
	protected double price;
	protected double weight;
	protected int item_id;
	
	private int equipment_id;
}
