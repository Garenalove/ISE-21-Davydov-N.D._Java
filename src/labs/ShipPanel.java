package labs;

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
	
	public void setParking(Parking parking,int lvl) {
		this.parking = parking;
		for(int i = 0;i<5;i++) {
			parking.lvlDown();
		}
		for(int i = 0;i<lvl;i++) {
			parking.lvlUp();
		}
		repaint();
	}
	
	public void setParking(Parking parking) {
		setParking(parking,5);
	}
	
	public Parking getParking() {
		return parking;
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	public ITransport getShip(int index) {
		return parking.getShipInParking(index);
	}
}
