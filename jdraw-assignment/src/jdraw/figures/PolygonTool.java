package jdraw.figures;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawView;

public class PolygonTool extends ToolBase {

	/**
	 * The context's view. This variable can be used as a shortcut, i.e.
	 * instead of calling context.getView().
	 */
	private DrawView view;

	public PolygonTool(DrawContext context) {
		this.view = context.getView();
	}

	private Polygon polygon = null;

	private void add(){
		polygon = new Polygon();
		view.getModel().addFigure(polygon);
	}

	@Override
	public void activate() { }

	@Override
	public void deactivate() { polygon = null; }

	@Override
	public void mouseDown(int x, int y, MouseEvent e) {
		if(polygon == null){ add(); }
	}

	@Override
	public void mouseDrag(int x, int y, MouseEvent e) {
		/*if(polygon.origin() != null){
			polygon.setRecent(x, y);
		}*/
	}

	@Override
	public void mouseUp(int x, int y, MouseEvent e) {
		Point o = polygon.origin();
		if(o == null || Math.sqrt(Math.pow(x-o.x, 2) + Math.pow(y-o.y, 2)) > 10){
			polygon.addPoint(x, y);
		} else if(o != null) {
			polygon = null;
		}
	}

	@Override
	public Cursor getCursor() {
		return new Cursor(Cursor.CROSSHAIR_CURSOR);
	}

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource(IMAGES + "rectangle.png"));
	}

	@Override
	public String getName() {
		return "Polygon";
	}

}
