package engine.error.exception;

import javax.swing.JOptionPane;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class ItemReadFileException extends Exception {
	public ItemReadFileException() {
		super();
	}
	
	public void printStackTrack() {
		String errorMessage = "Falha na leitura dos itens!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6840523347629328113L;

}
