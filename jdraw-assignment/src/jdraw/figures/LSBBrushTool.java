package jdraw.figures;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawView;

public class LSBBrushTool extends ToolBase {

	private LSDBrush newBrush = null;
	/**
	 * The context's view. This variable can be used as a shortcut, i.e.
	 * instead of calling context.getView().
	 */
	private DrawView view;

	public LSBBrushTool(DrawContext context) {
		this.view = context.getView();
	}

	@Override
	public void activate() { }

	@Override
	public void deactivate() { }

	@Override
	public void mouseDown(int x, int y, MouseEvent e) {
		newBrush = new LSDBrush();
		newBrush.addPoint(x, y);
		view.getModel().addFigure(newBrush);
	}

	@Override
	public void mouseDrag(int x, int y, MouseEvent e) {
		if(newBrush != null){ newBrush.addPoint(x, y); }
	}

	@Override
	public void mouseUp(int x, int y, MouseEvent e) {
		if(newBrush != null){ newBrush.addPoint(x, y); }
		newBrush = null;
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
		return "LSDBrush";
	}

}
