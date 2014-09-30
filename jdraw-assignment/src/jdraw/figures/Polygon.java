package jdraw.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureHandle;

public class Polygon extends FigureBase {

	private static final long serialVersionUID = -3723630615200876623L;
	private java.awt.Polygon figure;
	public Polygon(){
		this(new java.awt.Polygon());
	}
	public Polygon(java.awt.Polygon figure) {
		this.figure = figure;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawPolygon(figure);
		g.fillPolygon(figure);
	}

	public void addPoint(int x, int y) {
		figure.addPoint(x, y);
		notifyObservers(new FigureEvent(this));
	}

	public Point origin(){
		if(figure.npoints <= 0){ return null; }
		return new Point(figure.xpoints[0], figure.ypoints[0]);
	}

	@Override
	public void move(int dx, int dy) {
		if(dx != 0 || dy != 0){
			figure.translate(dx, dy);
			notifyObservers(new FigureEvent(this));
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return figure.contains(x, y);
	}

	@Override
	public void setBounds(Point origin, Point corner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		return figure.getBounds();
	}

	@Override
	public List<FigureHandle> getHandles() {
		return null;
	}

	@Override
	public Figure clone() {
		int[] xs = new int[figure.npoints];
		int[] ys = new int[figure.npoints];
		System.arraycopy(xs, 0, figure.xpoints, 0, figure.npoints);
		System.arraycopy(ys, 0, figure.ypoints, 0, figure.npoints);
		return new Polygon(new java.awt.Polygon(xs, ys, figure.npoints));
	}

}
