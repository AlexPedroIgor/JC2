package game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import engine.*;

public class Story {	
	public Story() {
		String gamePath = System.getProperty("user.dir");
		String dataPath = gamePath + System.getProperty("file.separator") + "data";
		String storyFileName = dataPath + System.getProperty("file.separator") + "gameEvents.txt";
		String choicesFileName = dataPath + System.getProperty("file.separator") + "gameChoices.txt";
		String responsesFileName = dataPath + System.getProperty("file.separator") + "gameResponses.txt";
		setup(storyFileName, choicesFileName, responsesFileName);
		setStoryTrack(1);
		this.onChoices = false;
		this.onBattle = false;
		this.storyLine = "0";
	}
	
	public Event getNextStoryEvent() {
		String currentStoryLine = this.getNextStoryLine();
		if(this.onChoices) {
			this.currentStoryEvent = new BlankEvent(currentStoryLine, this.choices);
			return this.currentStoryEvent;
		} else {
			this.currentStoryEvent = new BlankEvent(currentStoryLine, new ArrayList<Choice>());
			return this.currentStoryEvent;
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
	
	private void setup(String storyFileName, String choicesFileName, String responsesFileName) {
		try {
			this.storyFile = new FileReader(storyFileName);
			this.readStoryFile = new BufferedReader(this.storyFile);
			this.choicesFile = new FileReader(choicesFileName);
			this.readChoicesFile = new BufferedReader(this.choicesFile);
			this.responsesFile = new FileReader(responsesFileName);
			this.readResponsesFile = new BufferedReader(this.responsesFile);
		} catch(IOException e) {
			System.err.println("Erro na leitura dos arquivos: " + e.getMessage());
		}
	}
		
	private String getNextStoryLine() {
		try {
			this.nextStoryTrack();
			while(!this.storyLine.equals(Integer.toString(this.getCurrentStoryTrack()))) {
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
			} else {
				this.onChoices = false;
			}
			return currentStoryLine;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return this.storyLine;
	}
	
	private void updateResponses() {
		this.responses = new ArrayList<Event>();
		try {
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
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateChoices() {
		this.choices = new ArrayList<Choice>();
		try {
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
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
			
	private FileReader storyFile;
	private BufferedReader readStoryFile;
	private FileReader choicesFile;
	private BufferedReader readChoicesFile;
	private FileReader responsesFile;
	private BufferedReader readResponsesFile;
	
	private String storyLine;
	private Event currentStoryEvent;
	private Collection<Choice> choices;
	private ArrayList<Event> responses;
	private int storyTrack;
	private boolean onChoices;
	private boolean onBattle;
	
	public static final void main(String[] args) {
		Story story = new Story();
		
		System.out.println(System.getProperty("os.name"));
	    
		Event eventoInicial = story.getNextStoryEvent();
		
		Book livro = new Book("A História da Aranha-Morcego", eventoInicial, new Player(10, 10));
		
		System.out.println(livro.showHistoryBook());
		System.out.println(livro.showHistory());
		for(Choice choice:livro.nextEvents()) {
            System.out.println(choice.getDescription());
        }
		
		Scanner in = new Scanner(System.in);
		System.out.println("Escolha:  ");
		int i;
		i = in.nextInt();
		livro.selectChoice(i);
		livro.nextEvent(i);
		System.out.println(livro.showHistoryBook());
		System.out.println(livro.showHistory());
		
		in.close();
	}
}
