package labs;

public class MeatGrinder {
	private boolean state;
	private Meat meat;
	private Egg egg ;
	private Spice spice;

	public ForceMeat getForceMeat()
	{
		if(meat!=null &&
			egg !=null &&
			spice != null &
			state){
			meat = null;
			egg = null;
			spice = null;
			return new ForceMeat();
		} else{
			return null;
		}
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public void setEgg(Egg egg) {
		this.egg = egg;
	}

	public void setSpice(Spice spice) {
		this.spice = spice;
	}
	
	
}
