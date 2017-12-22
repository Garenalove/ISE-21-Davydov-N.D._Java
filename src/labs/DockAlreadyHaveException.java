package labs;

public class DockAlreadyHaveException extends Exception {
	public DockAlreadyHaveException() {
		super("В доках уже есть такая лодка.");
	}
}
