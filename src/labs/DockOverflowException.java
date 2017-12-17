package labs;

public class DockOverflowException extends Exception {
	public DockOverflowException() {
		super("В доках нет свободных мест");
	}
}
