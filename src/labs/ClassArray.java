package labs;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

public class ClassArray<T extends ITransport> implements Serializable, Comparable<ClassArray<T>>,Iterable<T> {
	private HashMap<Integer,T> places;
	private int maxCount;
	private T defaultValue;
	private int itIndex;
	public ClassArray(int size, T defaultValue) {
		this.defaultValue = defaultValue;
		places = new HashMap<Integer, T>();
		this.maxCount = size;
		itIndex = 0;
	}
	
	public int addShip(T ship) throws DockOverflowException, DockAlreadyHaveException {
		if(places.size() == maxCount) {
			throw new DockOverflowException();
		}
		boolean isMegaShip = ship instanceof UltaMegaBuffSuperMotorShip;
		int index = places.size();
		for(int i = 0;i<places.size();i++) {
			if(checkFreePlace(i)) {
				index = i;
			}
			if(ship.getClass().getTypeName() == places.get(i).getClass().getTypeName()) {
				if(isMegaShip) {
					if(((UltaMegaBuffSuperMotorShip)ship).equals(places.get(i))) {
						throw new DockAlreadyHaveException();
					}
				} else {
					if(((MotorShip)ship).equals(places.get(i))){
						throw new DockAlreadyHaveException();
					}
				}
			}
		}
		if(index != places.size()) {
			places.put(index, ship);
			return index;
		} else {
			places.put(places.size(), ship);
			return places.size()-1;
		}
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

	public int count() {
		return places.size();
	}
	
	@Override
	public int compareTo(ClassArray<T> arg0) {
		if(this.count() > arg0.count()) {
			return -1;
		} else if (this.count() < arg0.count()) {
			return 1;
		} else {
			Integer [] thisKeys = this.places.keySet().toArray(new Integer[this.count()]);
			Integer [] otherKeys = arg0.places.keySet().toArray(new Integer[this.count()]);
			for(int i = 0;i<places.size();i++) {
				if(this.places.get(thisKeys[i]).getClass().getName().equals(MotorShip.class.getName()) && 
						arg0.places.get(otherKeys[i]).getClass().getName().equals(UltaMegaBuffSuperMotorShip.class.getName())) {
					return 1;
				}
				if(this.places.get(thisKeys[i]).getClass().getName().equals(UltaMegaBuffSuperMotorShip.class.getName()) && 
						arg0.places.get(otherKeys[i]).getClass().getName().equals(MotorShip.class.getName())) {
					return -1;
				}
				if(this.places.get(thisKeys[i]).getClass().getName().equals(MotorShip.class.getName()) && 
						arg0.places.get(otherKeys[i]).getClass().getName().equals(MotorShip.class.getName())) {
					return ((MotorShip)this.places.get(thisKeys[i]))
							.compareTo((MotorShip)arg0.places.get(otherKeys[i]));
				}
				if(this.places.get(thisKeys[i]).getClass().getName().equals(UltaMegaBuffSuperMotorShip.class.getName()) && 
						arg0.places.get(otherKeys[i]).getClass().getName().equals(UltaMegaBuffSuperMotorShip.class.getName())) {
					return ((UltaMegaBuffSuperMotorShip)this.places.get(thisKeys[i]))
							.compareTo((UltaMegaBuffSuperMotorShip)arg0.places.get(otherKeys[i]));
				}
			}
		}
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return places.values().iterator();
	}


}
