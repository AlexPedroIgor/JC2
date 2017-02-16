package error.exception;

public class FullBagException extends Exception {
	public FullBagException() {
		super();
	}
	
	public void printStackTrace() {
		System.out.println("Mochila cheia!");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1896520528086784731L;
}
