package labs;

import java.awt.Graphics;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShipPanel extends JPanel {
	private ITransport ship;
	private Parking parking;
	private Logger logger;
	public ShipPanel() {
		super();
		parking = new Parking(5);
		logger = Logger.getGlobal();
		
	}
	@Override
	public void paint(Graphics g) {
		if(ship!=null) {
			try {
				parking.putShipInParking(ship);
				logger.info("Корабль добавлен в доки");
			} catch (DockOverflowException e) {
				logger.info(e.getMessage());
				JOptionPane.showMessageDialog(null,
					    e.getMessage(),
					    e.getMessage(),
					    JOptionPane.ERROR_MESSAGE);
			} catch (DockAlreadyHaveException e) {
				logger.info(e.getMessage());
				JOptionPane.showMessageDialog(null,
					    e.getMessage(),
					    e.getMessage(),
					    JOptionPane.ERROR_MESSAGE);
			} catch(Exception e) {
				logger.info(e.getMessage());
				JOptionPane.showMessageDialog(null,
					    e.getMessage(),
					    e.getMessage(),
					    JOptionPane.ERROR_MESSAGE);
			}
			ship = null;
		}
		super.paint(g);
		parking.drawMarking(g);
		parking.drawShips(g);
	}
	
	public void lvlUp() {
		parking.lvlUp();
	}
	
	public void lvlDown() {
		parking.lvlDown();
	}
	
	public void loadParking(String fileName) {
		this.parking.loadData(fileName);
		repaint();
	}
	
	
	public void saveParking(String fileName) {
		this.parking.saveData(fileName);
		repaint();
	}
	
	public void setShip(ITransport ship) {
		this.ship = ship;
	}
	public ITransport getShip(int index) {
		try {
			ITransport ship = parking.getShipInParking(index);
			logger.info("Взят корабль под номером: " + index);
			return ship;
		} catch (DockIndexOutOfRangeException e) {
			logger.info(e.getMessage());
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    e.getMessage(),
				    JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			logger.info(e.getMessage());
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    e.getMessage(),
				    JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public void sort() {
		this.parking.sort();
		repaint();
	}
}
