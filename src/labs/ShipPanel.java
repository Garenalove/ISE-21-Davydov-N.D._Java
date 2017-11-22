package labs;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ShipPanel extends JPanel {
	private ITransport ship;
	private Parking parking;
	
	public ShipPanel() {
		super();
		parking = new Parking();
		
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
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	public ITransport getShip(int index) {
		return parking.getShipInParking(index);
	}
}
