package engine.error.exception;

import javax.swing.JOptionPane;

public class FullBagException extends Exception {
	public FullBagException() {
		super();
	}
	
	public void printStackTrace() {
		System.out.println("Mochila cheia!");
		JOptionPane.showMessageDialog(null, "Mochila cheia!","",JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1896520528086784731L;
}
