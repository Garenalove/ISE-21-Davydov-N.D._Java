package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public interface ITransport extends Serializable {
	void moveCar();
	void drawCar(Graphics g);
	void setPosition(int x,int y);
	void loadPassenger(int count);
	int getPassenger();
	void setBodyColor(Color c);
}
