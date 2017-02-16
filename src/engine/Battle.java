package engine;
//JAVA LIBRARY
import java.util.ArrayList;
import java.util.Collection;

import game.Item;
/**
 * Created by Alex, Pedro & Igor on Feb/2017.
 */
public class Battle {
	public Battle(Player player) {
		this.player = player;
		enemy = new ArrayList<Enemy>();
		setStartBattle();
		setSelectItens();
		setAttack();
	}
	
	public void setStartBattle() {
		Collection<Choice> choices = new ArrayList<Choice>();
		Choice attackChoice = new BlankChoice("Atacar", this.attack);
		Choice selectItens = new BlankChoice("Inventário", this.selectItens);
		choices.add(attackChoice);
		choices.add(selectItens);
		this.startBattle = new BlankEvent("Batalha", choices);
	}
	
	public void setSelectItens() {
		Collection<Choice> choices = new ArrayList<Choice>();
		Choice returnBattleMenu = new BlankChoice("Voltar", this.startBattle);
		choices.add(returnBattleMenu);
		if(!this.player.getBag().isEmpty()) {
			for(Item item: this.player.getBag().getItemArray()) {
				Choice itemChoice = new UseItemChoice(item.getName(), item.getItemEvent());
				choices.add(itemChoice);
			}
		}
	}
	
	public void setAttack() {
		Collection<Choice> choices = new ArrayList<Choice>();
		if(!this.enemy.isEmpty()) {
			for(Enemy enemy:this.enemy) {
				Choice attackEnemyChoice = new BattleChoice(this.enemy.indexOf(enemy) + ":" + enemy.getName(),
						enemy.getBattleEvent(), enemy);
				choices.add(attackEnemyChoice);
			}
		}
		this.attack = new BattleEvent("Qual inimigo deseja atacar", choices);
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
	private ArrayList<Enemy> enemy;
	private Event startBattle;
	private Event selectItens;
	private Event attack;
	
	public static void main(String[] args) {
		Battle batalha = new Battle(new Player(10,10));
		System.out.println(batalha.selectItens.history());
	}
}
