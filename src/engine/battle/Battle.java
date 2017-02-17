package engine.battle;

import java.util.ArrayList;

import engine.Updatable;
import engine.charr.Enemy;
import engine.charr.Player;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class Battle implements Updatable {
	public Battle(Player player) {
		this.player = player;
		enemy = new ArrayList<Enemy>();
		setMode(BattleMode.START_BATTLE);
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
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
	
	public BattleMode getMode() {
		return mode;
	}

	public void setMode(BattleMode mode) {
		this.mode = mode;
	}

	private Player player;
	private ArrayList<Enemy> enemy;
	private BattleMode mode;
}
