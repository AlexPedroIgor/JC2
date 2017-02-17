package engine.error.exception;

import javax.swing.JOptionPane;

public class ItemReadFileException extends Exception {
	public ItemReadFileException() {
		super();
	}
	
	public void printStackTrack() {
		System.out.println("Falha na leitura dos itens!");
		JOptionPane.showMessageDialog(null, "Falha na leitura dos itens!","Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6840523347629328113L;

}
