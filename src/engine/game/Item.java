package engine.game;

/**
 * 
 * @author Pedro da Luz
 *
 */
public abstract class Item {
	
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
	
	
}
