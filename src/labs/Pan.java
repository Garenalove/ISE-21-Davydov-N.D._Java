package labs;

public class Pan {

	public Oil oil;
	public ForceMeat forceMeat;
	public Cutlet cutlet;
	public int temperature;

	public void cook(int temperature)
	{
		this.temperature += temperature;
		if (this.oil != null &&
			this.forceMeat != null &&
			this.temperature >= 100)
		{
			oil = null;
			forceMeat = null;
			cutlet = new Cutlet();
		}
        else
		{
			cutlet =  null;
		}
	}

	public Cutlet getCutlet() {
		return cutlet;
	}

	public void setOil(Oil oil) {
		this.oil = oil;
	}

	public void setForceMeat(ForceMeat forceMeat) {
		this.forceMeat = forceMeat;
	}
	
	
}
