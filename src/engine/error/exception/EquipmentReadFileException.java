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
		System.out.println("Falha na leitura dos equipamentos!");
		JOptionPane.showMessageDialog(null, "Falha na leitura dos equipamentos!","Erro",JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8595955538928157887L;

}
