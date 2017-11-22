package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ShipPanel extends JPanel {
	private ITransport ship;
	private Parking parking;
	
	public ShipPanel() {
		super();
		parking = new Parking(5);
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		parking.drawMarking(g);
		if(ship!=null) {
			parking.putShipInParking(ship);
			ship = null;
		}
		parking.drawShips(g);
	}
	
	public void lvlUp() {
		parking.lvlUp();
	}
	
	public void lvlDown() {
		parking.lvlDown();
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	public ITransport getShip(int index) {
		return parking.getShipInParking(index);
	}
}
