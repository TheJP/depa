package jdraw.figures;

import java.util.LinkedList;
import java.util.List;

import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

public abstract class FigureBase implements Figure {

	private static final long serialVersionUID = 2636606000975248885L;
	private List<FigureListener> listener = new LinkedList<>();

	/**
	 * Notifies all Listeners with the given event argument
	 * @param e
	 */
	protected void notifyObservers(FigureEvent e){
		for(FigureListener l : listener){ l.figureChanged(e); }
	}
	
	@Override
	public void addFigureListener(FigureListener l) {
		listener.add(l);
	}

	@Override
	public void removeFigureListener(FigureListener l) {
		listener.remove(l);
	}

	@Override
	public abstract Figure clone();
}
