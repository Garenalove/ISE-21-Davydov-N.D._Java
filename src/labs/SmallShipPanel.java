package labs;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SmallShipPanel extends JPanel {
	
	private ITransport ship;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(ship!=null) {
			ship.setPosition(22, 150);
			ship.drawCar(g);
		}
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
}
