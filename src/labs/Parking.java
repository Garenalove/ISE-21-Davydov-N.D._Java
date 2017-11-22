package labs;

import java.awt.Color;
import java.awt.Graphics;

public class Parking {
	
	ClassArray<ITransport> parking;
	private int countPlaces = 20;
	private int placeSizeWidth = 210;
	private int placeSizeHeight = 80;
	
	public Parking() {
		parking = new ClassArray<ITransport>(countPlaces,null);
	}
	
	public int putShipInParking(ITransport ship) {
		return parking.addShip(ship);
	}
	
	public ITransport getShipInParking(int ticket) {
		return parking.getShip(ticket);
	}
	
	public void drawShips(Graphics g) {
		for(int i = 0;i<countPlaces;i++) {
			ITransport ship = parking.popShip(i);
			if(ship!=null) {
				ship.setPosition(5 + i /5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 55);
				ship.drawCar(g);
			}
		}
	}
	
	public void drawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (countPlaces / 5) * placeSizeWidth, 400);
		for(int i = 0; i < countPlaces / 5; i++) {
			for(int j = 0; j< 6;j++) {
				g.drawLine(i * placeSizeWidth, j*placeSizeHeight,
						i*placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i*placeSizeWidth, 0, i*placeSizeWidth, 400);
		}
	}
}
