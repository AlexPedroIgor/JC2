package engine.error.exception;

import javax.swing.JOptionPane;

public class StoryReadFileException extends Exception {
	public StoryReadFileException() {
		super();
	}
	
	public void printStackTrack() {
		String errorMessage = "Falha na leitura dos arquivos da História!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4737223514207634127L;

}
