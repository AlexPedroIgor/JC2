package engine.error.exception;

import javax.swing.JOptionPane;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class EquipmentReadFileException extends Exception {
	public EquipmentReadFileException() {
		super();
	}
	
	public void printStackTrack() {
		String errorMessage = "Falha na leitura dos equipamentos!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8595955538928157887L;

}
