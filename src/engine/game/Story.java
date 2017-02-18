package engine.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import engine.error.exception.StoryResponsesReadFileException;
import engine.error.exception.StoryChoicesReadFileException;
import engine.error.exception.StoryReadFileException;
import engine.event.BlankChoice;
import engine.event.BlankEvent;
import engine.event.Choice;
import engine.event.Event;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class Story {	
	public Story() {
		try {
			setup();
		} catch (StoryReadFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish = false;
		setStoryTrack(0);
		onChoices = false;
		onBattle = false;
		storyLine = "0";
	}
	
	public Event getStoryEvent(int track) {
		try {
			String currentStoryLine = this.getStoryLine(track);
			if(this.getCurrentStoryTrack() >= track) {
				this.reset();
			}
			if(this.onChoices) {
				this.currentStoryEvent = new BlankEvent(currentStoryLine, this.choices);
				return this.currentStoryEvent;
			} else {
				this.currentStoryEvent = new BlankEvent(currentStoryLine, new ArrayList<Choice>());
				return this.currentStoryEvent;
			}
		} catch(StoryReadFileException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Event getNextStoryEvent() {
		this.nextStoryTrack();
		return this.getStoryEvent(this.getCurrentStoryTrack());
	}
	
	public void reset() {
		try {
			this.close();
			this.setup();
		} catch(StoryReadFileException e) {
			e.printStackTrace();
		}
	}
	
	public void close() throws StoryReadFileException {
		try {
			this.readStoryFile.close();
			this.readChoicesFile.close();
			this.readResponsesFile.close();
		} catch(IOException e) {
			throw new StoryReadFileException();
		}
	}
	
	public boolean isOnBattle() {
		return this.onBattle;
	}
	
	public void setStoryTrack(int storyTrack) {
		this.storyTrack = storyTrack;
	}
	
	public int getCurrentStoryTrack() {
		return this.storyTrack;
	}
	
	private void nextStoryTrack() {
		this.storyTrack++;
	}
	
	private void setup() throws StoryReadFileException {
		try {
			String gamePath = System.getProperty("user.dir");
			String dataPath = gamePath + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "story";
			String storyFileName = dataPath + System.getProperty("file.separator") + "gameEvents.txt";
			String choicesFileName = dataPath + System.getProperty("file.separator") + "gameChoices.txt";
			String responsesFileName = dataPath + System.getProperty("file.separator") + "gameResponses.txt";
			this.readStoryFile = new BufferedReader(
					new InputStreamReader(new FileInputStream(storyFileName), "UTF-8"));
			
			this.readChoicesFile = new BufferedReader(
					new InputStreamReader(new FileInputStream(choicesFileName), "UTF-8"));
				
			this.readResponsesFile = new BufferedReader(
					new InputStreamReader(new FileInputStream(responsesFileName), "UTF-8"));
		} catch(IOException e) {
			throw new StoryReadFileException();
		}
	}
	
	private String getStoryLine(int track) throws StoryReadFileException {
		try {
			while(!this.storyLine.equals(Integer.toString(track))) {
				this.storyLine = this.readStoryFile.readLine();
				if(this.storyLine == null) {
					this.storyLine = "Fim de Jogo";
					return this.storyLine;
				}
			}
			this.storyLine = this.readStoryFile.readLine();
			String currentStoryLine = this.storyLine;
			this.storyLine = this.readStoryFile.readLine();
			if(this.storyLine.equals("[end]"))
				this.finish = true;
			if(this.storyLine.contains("[choice]")) {
				try {
					this.updateResponses();
				} catch(StoryResponsesReadFileException e) {
					e.printStackTrace();
				} try {
					this.updateChoices();
				} catch(StoryChoicesReadFileException e) {
					e.printStackTrace();
				}
				this.onChoices = true;
			} else if (this.storyLine.contains("[battle]")) {
				this.onBattle = true;
			} else {
				this.onChoices = false;
				this.onBattle = false;
			}
			currentStoryLine = interpretCode(currentStoryLine);
			return currentStoryLine;
		} catch(IOException e) {
			throw new StoryReadFileException();
		}
	}
	
	private void updateResponses() throws StoryResponsesReadFileException {
		try {
			this.responses = new ArrayList<Event>();
			String responseLine = this.readResponsesFile.readLine();
			if(responseLine.equals(Integer.toString(this.getCurrentStoryTrack())))
				responseLine = this.readResponsesFile.readLine();
			while(!responseLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
				if(!responseLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
					Event responseEvent = new BlankEvent(responseLine, new ArrayList<Choice>());
					this.responses.add(responseEvent);
				}
				responseLine = interpretCode(responseLine);
				responseLine = this.readResponsesFile.readLine();
			}
		} catch(IOException e) {
			throw new StoryResponsesReadFileException();
		}
	}
	
	private void updateChoices() throws StoryChoicesReadFileException {
		try {
			this.choices = new ArrayList<Choice>();
			String choiceLine = this.readChoicesFile.readLine();
			if(choiceLine.equals(Integer.toString(this.getCurrentStoryTrack())))
				choiceLine = this.readChoicesFile.readLine();
			while(!choiceLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
				if(!choiceLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
					Choice choiceEvent = new BlankChoice(choiceLine, this.responses.get(this.choices.size()));
					this.choices.add(choiceEvent);
				}
				choiceLine = interpretCode(choiceLine);
				choiceLine = this.readChoicesFile.readLine();
			}
		} catch(IOException e) {
			throw new StoryChoicesReadFileException();
		}
	}
	
	public static String interpretCode(String line) {
		line = line.replaceAll(" \\[p\\] ", "\n");
		return line;
	}
	
	public boolean finishReadingStory() {
		return this.finish;
	}
			
	private BufferedReader readStoryFile;
	private BufferedReader readChoicesFile;
	private BufferedReader readResponsesFile;
	
	private String storyLine;
	private Event currentStoryEvent;
	private Collection<Choice> choices;
	private ArrayList<Event> responses;
	private int storyTrack;
	private boolean onChoices;
	private boolean onBattle;
	private boolean finish;
}
