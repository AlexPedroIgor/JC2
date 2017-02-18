package engine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import engine.charr.Player;
import engine.error.exception.ConfigReadFileException;
import engine.error.exception.StoryReadFileException;
import engine.event.Choice;
import engine.game.Story;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class Engine {	
	public void setupBook(int playerId) {
		setPlayerId(playerId);
		this.story = new Story();
		this.story.setStoryTrack(1);
		this.book = new Book(getStoryName(), story.getNextStoryEvent(), new Player(this.playerId));
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	private String getStoryName() {
		try {
			String storyName = getFromConfig("storyName");
			return storyName;
		} catch(ConfigReadFileException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getFromConfig(String varName) throws ConfigReadFileException {
		try {
			String gamePath = System.getProperty("user.dir");
			String dataPath = gamePath + System.getProperty("file.separator") + "data";
			String configFile = dataPath + System.getProperty("file.separator") + "config.ini";
			BufferedReader readConfig = new BufferedReader(
					new InputStreamReader(new FileInputStream(configFile), "UTF-8"));
			String line = readConfig.readLine();
			while(line != null) {
				if(line.split("=")[0].equals(varName)) {
					readConfig.close();
					return line.split("=")[1];
				}
				line = readConfig.readLine();
			}
			readConfig.close();
			return null;
		} catch(IOException e) {
			throw new ConfigReadFileException();
		}
	}
	
	public String showBookName() {
		return book.showHistoryBook();
	}
	
	public boolean isRunning() {
		if(story.finishReadingStory())
			return false;
		return true;
	}
	
	private Story story;
	private Book book;	
	private int playerId;
	
    public static void main(String[] args) {
    	Engine engine = new Engine();
    	engine.setupBook(1);
		
		System.out.println(engine.showBookName());
		System.out.println(engine.book.showHistory());
		for(Choice choice:engine.book.nextEvents()) {
            System.out.println(choice.getDescription());
        }
		
		Scanner in = new Scanner(System.in);
		System.out.println("Escolha:  ");
		int i;
		i = in.nextInt();
		engine.book.selectChoice(i);
		engine.book.nextEvent(i);
		System.out.println(engine.book.showHistoryBook());
		System.out.println(engine.book.showHistory());
		
		engine.story.reset();
		
		in.close();
		try {
			engine.story.close();
		} catch (StoryReadFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
