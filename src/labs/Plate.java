package labs;

public class Plate {
	
	private Pan pan;

	public void cookIng()
	{
		pan.cook(1);
	}

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}
	
	
}
