package labs;

public class ClassArray<T> {
	private T[] places;
	private T defaultValue;
	
	public ClassArray(int size, T defaultValue) {
		this.defaultValue = defaultValue;
		places = (T[])(new Object[size]);
		for(int i = 0;i<places.length;i++) {
			places[i] = defaultValue;
		}
	}
	
	public int addShip(T ship) {
		for(int i = 0;i<places.length;i++) {
			if(checkFreePlace(i)) {
				places[i] = ship;
				return i;
			}
		}
		return -1;
	}
	
	public T getShip(int index) {
		if(!checkFreePlace(index)) {
			T ship = places[index];
			places[index] = defaultValue;
			return ship;
		}
		return defaultValue;
	}
	
	public T popShip(int index) {
		if(!checkFreePlace(index)) {
			return places[index];
		}
		return defaultValue;
	}
	
	private boolean checkFreePlace(int index) {
		if(index < 0 || index > places.length) {
			return false;
		}
		if(places[index] == null) {
			return true;
		}
		if(places[index].equals(defaultValue)) {
			return true;
		}
		return false;
	}
}
