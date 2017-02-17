package engine.game;

import java.util.ArrayList;

import engine.error.exception.FullBagException;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class Bag {
	public Bag(double maxWeight) {
		item = new ArrayList<Item>();
		setMaxWeight(maxWeight);
	}
	
	public void addItem(Item item) throws FullBagException {
		if( (item.getWeight() + this.getCurrentWeight()) > this.getMaxWeight()) {
			throw new FullBagException();
		} else {
			this.addWeight(item.getWeight());
			this.item.add(item);
		}
	}
	
	public void removeItem(int id) {
		double weight = this.item.get(id).getWeight();
		this.removeWeight(weight);
		this.item.remove(id);
	}
	
	public void removeItem(String name) {
		Integer id = null;
		for(Item item:this.item) {
			if(item.getName().equals(name)) {
				id = new Integer(this.item.indexOf(item));
				break;
			}
		}
		if(id != null) {
			this.removeItem(id);
		}
	}
	
	public boolean isEmpty() {
		return this.item.isEmpty();
	}
	
	public ArrayList<Item> getItemArray() {
		return this.item;
	}
	
	public Item getItem(int id) {
		return this.item.get(id);
	}
	
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	
	public double getMaxWeight() {
		return this.maxWeight;
	}
	
	public double getCurrentWeight() {
		return this.carrying;
	}
	
	public void addWeight(double weight) {
		this.carrying += weight;
	}
	
	public void removeWeight(double weight) {
		this.carrying -= weight;
	}
	
	private ArrayList<Item> item;
	
	private double maxWeight;
	private double carrying;
	
	public static void main(String[] args) {
		Bag bag = new Bag(0.5);
		Item item = new Item(1);
		try {
			bag.addItem(item);
		} catch (FullBagException e) {
			e.printStackTrace();
		}
	}
}
