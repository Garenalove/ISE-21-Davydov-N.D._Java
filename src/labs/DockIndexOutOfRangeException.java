package labs;

public class DockIndexOutOfRangeException extends Exception {
	public DockIndexOutOfRangeException() {
		super("В доках нет корабля по такому адресу");
	}
}
