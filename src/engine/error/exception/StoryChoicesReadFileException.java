package engine.error.exception;

import javax.swing.JOptionPane;

public class StoryChoicesReadFileException extends StoryReadFileException {
	public StoryChoicesReadFileException() {
		super();
	}
	
	public void printStackTrace() {
		String errorMessage = "Falha na leitura das perguntas!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210474062963747799L;

}
