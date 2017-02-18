package engine.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import engine.error.exception.ItemReadFileException;

public class GenericItem extends Item {
	public GenericItem(int id) {
		try {
			setup(id);
		} catch(ItemReadFileException e) {
			e.printStackTrace();
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
			//int equipment_id;
			
			do {
				line = readItensFile.readLine();
				currentID = new Integer(line.split(";")[0]);
				name = new String(line.split(";")[1]);
				price = new Double(line.split(";")[2]);
				weight = new Double(line.split(";")[3]);
				//equipment_id = new Integer(line.split(";")[4]);
			} while(currentID != id);
			readItensFile.close();
			
			setName(name);
			setPrice(price);
			setWeight(weight);
			//setEquipment_id(equipment_id);
		} catch(IOException e) {
			throw new ItemReadFileException();
		}
	}
	
	/*public int getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}

	protected int equipment_id;*/
}
