package engine.error.exception;

import javax.swing.JOptionPane;
/**
 * 
 * @author Pedro da Luz
 *
 */
public class FullBagException extends Exception {
	public FullBagException() {
		super();
	}
	
	public void printStackTrace() {
		String errorMessage = "Mochila cheia!";
		System.out.println(errorMessage);
		JOptionPane.showMessageDialog(null, errorMessage,"",JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1896520528086784731L;
}
