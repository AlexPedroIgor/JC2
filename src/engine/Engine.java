package engine;
// JAVA LIBRARY
import java.io.IOException;
import java.util.Scanner;
// INTERNAL LIBRARY
import game.Story;
/**
 * Created by filipebraida on 31/05/16.
 * Edited by Alex, Pedro & Igor on Jan/2017
 */
public class Engine {
    public static void main(String[] args) throws IOException {
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
