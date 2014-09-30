package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;

public class LSDBrush extends FigureBase {

	private final static int BRUSH_SIZE = 20; 
	private Random r = new Random();
	private List<Point> points = new ArrayList<>();

	@Override
	public void draw(Graphics g) {
		for(Point p : points){
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.fillOval(p.x, p.y, BRUSH_SIZE, BRUSH_SIZE);
		}
	}

	public void addPoint(int x, int y){
		points.add(new Point(x, y));
		notifyObservers(new FigureEvent(this));
	}

	@Override
	public void move(int dx, int dy) {
		if(dx != 0 || dy != 0){
			for(Point p : points){ p.x += dx; p.y += dy; }
			notifyObservers(new FigureEvent(this));
		}
	}

	@Override
	public boolean contains(int x, int y) {
		for(Point p : points){
			if(Math.sqrt(Math.pow(p.x-x, 2) + Math.pow(p.y-y, 2)) <= BRUSH_SIZE){
				return true;
			}
		}
		return false;
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		// TODO Auto-generated method stub
	}

	@Override
	public Rectangle getBounds() {
		Point min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Point max = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
		for(Point p : points){
			min.x = Math.min(min.x, p.x - BRUSH_SIZE);
			max.x = Math.max(max.x, p.x + BRUSH_SIZE);
			min.y = Math.min(min.y, p.y - BRUSH_SIZE);
			max.y = Math.max(max.y, p.y + BRUSH_SIZE);
		}
		return new Rectangle(min.x, min.y, max.x - min.x, max.y - min.y);
	}

	@Override
	public List<FigureHandle> getHandles() {
		return null;
	}

	@Override
	public Figure clone() {
		LSDBrush cln = new LSDBrush();
		for(Point p : points){ cln.points.add(new Point(p.x, p.y)); } 
		return cln;
	}

}
