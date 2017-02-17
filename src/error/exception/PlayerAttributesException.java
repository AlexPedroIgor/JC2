package error.exception;

import javax.swing.JOptionPane;

public class PlayerAttributesException extends Exception {
	public PlayerAttributesException() {
		super();
	}
	
	public void printStackTrack() {
		System.out.println("Falha na leitura de atributos do jogador");
		JOptionPane.showMessageDialog(null, "Falha na leitura de atributos do jogador!","Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6870731299410005043L;

}
