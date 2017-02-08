package engine;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
	public static void main(String[] args){
		Event eventoFinal = new BlankEvent("Você morreu porque o Duarte" +
			    "não mandou ir para a trilha.", new ArrayList<Choice>());

		Collection<Choice> escolhasIniciais = new ArrayList<Choice>();
		Choice escolhaFinalTrilha = new BlankChoice("Segue a trilha", eventoFinal);
		Choice escolhaFinalFloresta = new BlankChoice("Fica na floresta", eventoFinal);
		escolhasIniciais.add(escolhaFinalTrilha);
		escolhasIniciais.add(escolhaFinalFloresta);

		Event eventoInitial = new BlankEvent("Você está em uma floresta. " +
		    "O Sensei Duarte falou para você ficar na floresta treinando "
		    , escolhasIniciais);

		Book livro = new Book("A história da Rural", eventoInitial, new Player(10, 10));
		System.out.println(livro.showHistoryBook());
		System.out.println(livro.showHistory());
		System.out.println(escolhaFinalTrilha.getDescription());
		System.out.println(livro.selectChoice(0));
		
		
	}
}
