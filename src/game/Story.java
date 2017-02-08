package game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Story {
	private FileReader file;
	private BufferedReader readFile;
	
	private void setFile(String fileName) {
		try {
			this.file = new FileReader(fileName);
			this.readFile = new BufferedReader(this.file);
		} catch(IOException e) {
			System.err.printf("Erro na leitura do arquivo: $s", e.getMessage());
		}
	}
	
	public String getNextStoryTake() {
		String line = new String();
		try {
			line = this.readFile.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		if(line != null)
			return line;
		return "Fim de Jogo";
	}
	
	public Story() {
		setFile("gameStory.txt");
	}
	
	
	public static final void main(String[] args) {
		Story story = new Story();
	    System.out.printf("\nConteúdo do arquivo texto:\n");
	    
	    try {
	    	FileReader arq = new FileReader("gameStory.txt");
	    	BufferedReader lerArq = new BufferedReader(arq);
	 
	    	String linha = lerArq.readLine();
	     
	    	while (linha != null) {
	    		System.out.printf("%s\n", linha);
	 
	    		linha = lerArq.readLine();
	    	}
	 
	    	arq.close();
	    	} catch (IOException e) {
	    		System.err.println("Erro na abertura do arquivo:" + e.getMessage());
	    	}
	 
	    System.out.println();
	}
}
