package engine.error.exception;

import javax.swing.JOptionPane;

public class StoryResponsesReadFileException extends StoryReadFileException {
	public StoryResponsesReadFileException() {
		super();
	}
	
	public void printStackTrace() {
		String errorMessage = "Falha na leitura das respostas!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6099501063089292270L;

}
