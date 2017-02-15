package game;
/**
 * Created by Alex, Pedro & Igor on Jan/2017.
 */
public class PlayerAttributes extends Attributes {
	public PlayerAttributes() {
		super();
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
	
	private int social;
	private int sanity;
	private int luck;
}
