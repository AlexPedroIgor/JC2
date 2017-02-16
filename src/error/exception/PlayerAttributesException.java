package error.exception;

public class PlayerAttributesException extends Exception {
	public PlayerAttributesException() {
		super();
	}
	
	public void printStackTrack() {
		System.out.println("Falha na leitura de atributos do jogador");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6870731299410005043L;

}
