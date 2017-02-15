package engine;
//JAVA LIBRARY
import java.util.ArrayList;
import java.util.Collection;
/**
 * Created by Alex, Pedro & Igor on Feb/2017.
 */
public class Battle {
	public Battle(Player player) {
		this.player = player;
		enemy = new ArrayList<Enemy>();
		setStartBattle();
	}
	
	public void setStartBattle() {
		Collection<Choice> choices = new ArrayList<Choice>();
		Choice attackChoice = new BlankChoice("Atacar", this.attack);
		Choice selectItens = new BlankChoice("Inventário", this.selectItens);
		choices.add(attackChoice);
		choices.add(selectItens);
		this.startBattle = new BlankEvent("Batalha", choices);
	}
	
	public void addEnemy(Enemy enemy) {
		this.enemy.add(enemy);
	}
	
	public void killEnemy(int id) {
		this.enemy.remove(id);
	}
	
	public int enemyQnt() {
		return this.enemy.size();
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	private Player player;
	private Collection<Enemy> enemy;
	private Event startBattle;
	private Event selectItens;
	private Event attack;
}
