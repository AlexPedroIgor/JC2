package engine.battle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import engine.Book;
import engine.Enemy;
import engine.Player;
import engine.event.BattleChoice;
import engine.event.BattleEvent;
import engine.event.BlankChoice;
import engine.event.BlankEvent;
import engine.event.Choice;
import engine.event.Event;
import engine.event.UseItemChoice;
import game.Item;
/**
 * Created by Alex, Pedro & Igor on Feb/2017.
 */
public class Battle {
	public Battle(Player player) {
		//this.player = player;
		enemy = new ArrayList<Enemy>();
		setStartBattle();
		this.battleBook = new Book("Batalha", this.startBattle, player);
		setSelectItens();
		setAttack();
		setStartBattle();
	}
	
	public void setStartBattle() {
		Collection<Choice> choices = new ArrayList<Choice>();
		Choice attackChoice = new BlankChoice("Atacar", this.attack);
		Choice defendChoice = new BlankChoice("Defender", this.defend);
		Choice selectItens = new BlankChoice("Inventário", this.selectItens);
		choices.add(attackChoice);
		choices.add(defendChoice);
		choices.add(selectItens);
		this.startBattle = new BlankEvent("Batalha", choices);
	}
	
	public void setSelectItens() {
		Collection<Choice> choices = new ArrayList<Choice>();
		Choice returnBattleMenu = new BlankChoice("Voltar", this.startBattle);
		choices.add(returnBattleMenu);
		if(!this.battleBook.getPlayer().getBag().isEmpty()) {
			for(Item item: this.battleBook.getPlayer().getBag().getItemArray()) {
				Choice itemChoice = new UseItemChoice(item.getName(), item.getItemEvent());
				choices.add(itemChoice);
			}
		}
		this.selectItens = new BlankEvent("Selecione um item", choices);
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
	
	public int howManyEnemies() {
		return this.enemy.size();
	}
	
	/*public Player getPlayer() {
		return this.player;
	}*/
	
	private Book battleBook;
	//private Player player;
	private ArrayList<Enemy> enemy;
	private Event startBattle;
	private Event selectItens;
	private Event attack;
	private Event defend;
	
	public static void main(String[] args) {
		Player player = new Player(1);
		Battle batalha = new Battle(player);/*
		System.out.println(batalha.startBattle.history());
		for(Choice choice:batalha.startBattle.nextEvents()) {
            System.out.println(choice.getDescription());
        }
		System.out.println(batalha.selectItens.history());
		for(Choice choice:batalha.selectItens.nextEvents()) {
            System.out.println(choice.getDescription());
        }
		System.out.println(batalha.attack.history());
		for(Choice choice:batalha.attack.nextEvents()) {
            System.out.println(choice.getDescription());
        }*/
		
		
		//System.out.println(batalha.battleBook.showHistoryBook());
		System.out.println(batalha.battleBook.showHistory());
		for(Choice choice:batalha.battleBook.nextEvents()) {
            System.out.println(choice.getDescription());
        }
		
		Scanner in = new Scanner(System.in);
		System.out.println("Escolha:  ");
		int i;
		i = in.nextInt();
		batalha.battleBook.selectChoice(i);
		batalha.battleBook.nextEvent(i);
		System.out.println(batalha.battleBook.showHistoryBook());
		System.out.println(batalha.battleBook.showHistory());
		in.close();
	}
}
