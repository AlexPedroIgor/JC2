package engine.battle;

import java.util.ArrayList;

import engine.charr.Enemy;
import engine.charr.Player;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class Battle {
	public Battle(Player player) {
		this.player = player;
		enemy = new ArrayList<Enemy>();
	}
	
	public void addEnemy(Enemy enemy) {
		this.enemy.add(enemy);
	}
	
	public void killEnemy(int id) {
		this.enemy.remove(id);
	}
	
	public int howManyEnemies() {
		return this.enemy.size();
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	private Player player;
	private ArrayList<Enemy> enemy;
	
	public static void main(String[] args) {
		Player player = new Player(1);
		Battle batalha = new Battle(player);
	}
}
