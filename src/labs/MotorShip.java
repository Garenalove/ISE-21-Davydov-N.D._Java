package labs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

import javax.print.attribute.standard.MediaSize.Other;

public class MotorShip extends Ship implements Comparable<Object>{
	
	public MotorShip(int maxSpeed,int maxCountPassengers, float weight,Color color) {
		this.colorBody = color;
		this.setWeight(weight);
		this.setMaxCountPassengers(maxCountPassengers);
		this.maxSpeed = maxSpeed;
		
		Random r = new Random();
		this.posX = (r.nextInt(190) +10);
		this.posY = (r.nextInt(190) +10);
		
	}

	@Override
	public void moveCar() {
		posX +=
				(maxSpeed * 50 / weight) / 
				(countPassengers == 0 ? 1 : countPassengers);
		
	}

	@Override
	public void drawCar(Graphics g) {
		drawMotorShip(g);
		
	}
	
	protected void drawMotorShip(Graphics g) {
		g.setColor(Color.BLACK);
        Polygon points = new Polygon();
        points.addPoint(posX, posY);
        points.addPoint(posX + 60, posY);
        points.addPoint(posX + 70, posY - 10);
        points.addPoint(posX + 100, posY - 10);
        points.addPoint(posX + 80, posY + 20);
        points.addPoint(posX + 10, posY + 20);
        points.addPoint(posX, posY);
        g.drawPolygon(points);
        points = new Polygon();
        points.addPoint(posX + 10, posY);
        points.addPoint(posX + 10, posY - 20);
        points.addPoint(posX + 20, posY - 20);
        points.addPoint(posX + 20, posY - 30);
        points.addPoint(posX + 30, posY - 30);
        points.addPoint(posX + 30, posY - 50);
        points.addPoint(posX + 50, posY - 50);
        points.addPoint(posX + 50, posY - 30);
        points.addPoint(posX + 70, posY - 30);
        points.addPoint(posX + 70, posY - 20);
        points.addPoint(posX + 80, posY - 20);
        points.addPoint(posX + 80, posY - 10);
        points.addPoint(posX + 70, posY - 10);
        points.addPoint(posX + 60, posY);
        points.addPoint(posX + 10, posY);
        g.drawPolygon(points);
        g.drawLine(posX + 10, posY - 20, posX + 70, posY - 20);
        g.drawLine(posX + 20, posY - 30, posX + 60, posY - 30);
        g.drawLine(posX + 30, posY - 45, posX + 50, posY - 45);
        g.setColor(colorBody);
        g.drawRect(posX + 20, posY - 15, 10, 10);
        g.drawRect(posX + 30, posY - 15, 10, 10);
        g.drawRect(posX + 70, posY, 10, 10);
        for(int i = 0; i < 5; i++)
        {
            g.drawOval(posX + 22 + (10 * i), posY - 27, 5, 5);
        }
		
	}

	protected void setMaxCountPassengers(int value) {
		if(value>0 && value<5) {
			super.maxCountPassengers = value;
		} else {
			super.maxCountPassengers = value;
		}
	}
	
	protected void setWeight(float value){
		if(value>500 && value<1500) {
			super.weight = value;
		} else {
			super.weight = 1000;
		}
	}

	@Override
	public int compareTo(Object other) {
		MotorShip o = null;
		if(other == null) {
			return 1;
		}
		if(other instanceof MotorShip) {
			o = (MotorShip)other;
		} else {
			return 1;
		}
		if(maxSpeed != o.maxSpeed) {
			return maxSpeed > o.maxSpeed ? 1 : -1;
		}
		if(maxCountPassengers != o.maxCountPassengers) {
			return maxCountPassengers > o.maxCountPassengers ? 1 : -1;
		}
		if(weight != o.weight) {
			return weight > o.weight ? 1 : -1;
		}
		if(colorBody.getRGB() != o.colorBody.getRGB()) {
			return colorBody.getRGB() > o.colorBody.getRGB() ? 1 : -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		MotorShip otherShip = null;
		if(o instanceof MotorShip) {
			otherShip = (MotorShip)o;
		} else {
			return false;
		}
		if(maxSpeed != otherShip.maxSpeed) {
			return false;
		}
		if(maxCountPassengers != otherShip.maxCountPassengers) {
			return false;
		}
		if(weight != otherShip.weight) {
			return false;
		}
		if(colorBody.getRGB() != otherShip.colorBody.getRGB()) {
			return false;
		}
		return true;
	}

}
