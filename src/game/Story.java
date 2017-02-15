package game;
// JAVA LIBRARY
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
// INTERNAL LIBRARY
import engine.*;
/**
 * Created by Alex, Pedro & Igor on Jan/2017.
 */
public class Story {	
	public Story() throws IOException {
		setup();
		setStoryTrack(1);
		onChoices = false;
		onBattle = false;
		storyLine = "0";
	}
	
	public Event getStoryEvent(int track) throws IOException {
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
	}
	
	public Event getNextStoryEvent() throws IOException {
		this.nextStoryTrack();
		return this.getStoryEvent(this.getCurrentStoryTrack());
	}
	
	public void reset() throws IOException {
		this.readStoryFile.close();
		this.readChoicesFile.close();
		this.readResponsesFile.close();
		this.setup();
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
	
	private void setup() throws IOException {
		String gamePath = System.getProperty("user.dir");
		String dataPath = gamePath + System.getProperty("file.separator") + "data";
		String storyFileName = dataPath + System.getProperty("file.separator") + "gameEvents.txt";
		String choicesFileName = dataPath + System.getProperty("file.separator") + "gameChoices.txt";
		String responsesFileName = dataPath + System.getProperty("file.separator") + "gameResponses.txt";
		this.readStoryFile = new BufferedReader(
				new InputStreamReader(new FileInputStream(storyFileName), "UTF-8"));
		
		this.readChoicesFile = new BufferedReader(
				new InputStreamReader(new FileInputStream(choicesFileName), "UTF-8"));
			
		this.readResponsesFile = new BufferedReader(
				new InputStreamReader(new FileInputStream(responsesFileName), "UTF-8"));
	}
	
	private String getStoryLine(int track) throws IOException {
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
		if(this.storyLine.equals("[choice]")) {
			this.updateResponses();
			this.updateChoices();
			this.onChoices = true;
		} else if (this.storyLine.equals("[battle]")) {
			this.onBattle = true;
		} else {
			this.onChoices = false;
			this.onBattle = false;
		}
		return currentStoryLine;
	}
	
	private void updateResponses() throws IOException {
		this.responses = new ArrayList<Event>();
		String responseLine = this.readResponsesFile.readLine();
		if(responseLine.equals(Integer.toString(this.getCurrentStoryTrack())))
			responseLine = this.readResponsesFile.readLine();
		while(!responseLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
			if(!responseLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
				Event responseEvent = new BlankEvent(responseLine, new ArrayList<Choice>());
				this.responses.add(responseEvent);
			}
			responseLine = this.readResponsesFile.readLine();
		}
	}
	
	private void updateChoices() throws IOException {
		this.choices = new ArrayList<Choice>();
		String choiceLine = this.readChoicesFile.readLine();
		if(choiceLine.equals(Integer.toString(this.getCurrentStoryTrack())))
			choiceLine = this.readChoicesFile.readLine();
		while(!choiceLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
			if(!choiceLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
				Choice choiceEvent = new BlankChoice(choiceLine, this.responses.get(this.choices.size()));
				this.choices.add(choiceEvent);
			}
			choiceLine = this.readChoicesFile.readLine();
		}
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
}
