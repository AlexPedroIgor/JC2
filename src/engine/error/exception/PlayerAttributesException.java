package engine.error.exception;

import javax.swing.JOptionPane;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class PlayerAttributesException extends Exception {
	public PlayerAttributesException() {
		super();
	}
	
	public void printStackTrack() {
		String errorMessage = "Falha na leitura de atributos do jogador";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6870731299410005043L;

}
