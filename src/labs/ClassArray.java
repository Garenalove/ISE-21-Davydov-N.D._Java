package labs;

import java.io.Serializable;
import java.util.HashMap;

public class ClassArray<T extends ITransport> implements Serializable {
	private HashMap<Integer,T> places;
	private int maxCount;
	private T defaultValue;
	
	public ClassArray(int size, T defaultValue) {
		this.defaultValue = defaultValue;
		places = new HashMap<Integer, T>();
		this.maxCount = size;
	}
	
	public int addShip(T ship) throws DockOverflowException {
		for(int i = 0;i<maxCount;i++) {
			if(checkFreePlace(i)) {
				places.put(i, ship);
				return i;
			}
		}
		throw new DockOverflowException();
	}
	
	public T getShip(int index) throws DockIndexOutOfRangeException {
		if(!checkFreePlace(index)) {
			T ship = places.get(index);
			places.remove(index);
			return ship;
		}
		throw new DockIndexOutOfRangeException();
	}
	
	public T popShip(int index) throws DockIndexOutOfRangeException {
		if(!checkFreePlace(index)) {
			return places.get(index);
		}
		throw new DockIndexOutOfRangeException();
	}
	
	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}
}
