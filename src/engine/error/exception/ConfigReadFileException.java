package engine.error.exception;

import javax.swing.JOptionPane;

public class ConfigReadFileException extends Exception {
	public ConfigReadFileException() {
		super();
	}
	
	public void printStackTrace() {
		String errorMessage = "Falha na leitura do arquivo config!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7970449443115849614L;

}
