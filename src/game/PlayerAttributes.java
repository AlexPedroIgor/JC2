package game;
// JAVA LIBRARIES
import java.io.IOException;

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
	
	public void setAttributes(int id) throws IOException {
		id++;
	}
	
	private int social;
	private int sanity;
	private int luck;
}
