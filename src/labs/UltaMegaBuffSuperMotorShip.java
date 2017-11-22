package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class UltaMegaBuffSuperMotorShip extends MotorShip {
	
	private boolean pipe;
	private boolean boat;
	private Color dopColor;
	public UltaMegaBuffSuperMotorShip(int maxSpeed, int maxCountPassengers,
			float weight, Color color,boolean pipe,boolean boat,Color dopColor) {
		super(maxSpeed, maxCountPassengers, weight, color);
		this.pipe = pipe;
		this.boat = boat;
		this.dopColor = dopColor;
	}
	
	@Override
	protected void drawMotorShip(Graphics g) {
		super.drawMotorShip(g);
		Polygon points = new Polygon();
        g.setColor(dopColor);
        if (pipe) {
            points.addPoint(posX + 25, posY - 40);
            points.addPoint(posX + 25, posY - 45);
            points.addPoint(posX + 55, posY - 45);
            points.addPoint(posX + 55, posY - 40);
            points.addPoint(posX + 25, posY - 40);
            g.drawPolygon(points);
        }
        if (boat) {
            points = new Polygon();
            points.addPoint(posX+15, posY+7);
            points.addPoint(posX + 45, posY+7);
            points.addPoint(posX + 50, posY+2);
            points.addPoint(posX + 65, posY+2);
            points.addPoint(posX + 55, posY + 17);
            points.addPoint(posX + 20, posY + 17);
            points.addPoint(posX+15, posY+7);
            g.drawPolygon(points);
        }
	}

}
