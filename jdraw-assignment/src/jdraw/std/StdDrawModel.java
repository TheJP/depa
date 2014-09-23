/*
 * Copyright (c) 2000-2013 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.LinkedList;
import java.util.List;

import jdraw.framework.DrawCommandHandler;
import jdraw.framework.DrawModel;
import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelEvent.Type;
import jdraw.framework.DrawModelListener;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author JP
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {

	private List<DrawModelListener> listener = new LinkedList<>();
	private void notifyObservers(DrawModelEvent e){
		for(DrawModelListener l : listener){ l.modelChanged(e); }
	}

	private List<Figure> figures = new LinkedList<>();
	@Override
	public void figureChanged(FigureEvent e) {
		notifyObservers(new DrawModelEvent(this, e.getFigure(), Type.FIGURE_CHANGED));
	}

	@Override
	public void addFigure(Figure f) {
		if(!figures.contains(f)){
			figures.add(f);
			f.addFigureListener(this);
			notifyObservers(new DrawModelEvent(this, f, Type.FIGURE_ADDED));
		}
	}

	@Override
	public Iterable<Figure> getFigures() {
		return figures;
	}

	@Override
	public void removeFigure(Figure f) {
		if(figures.remove(f)){
			f.removeFigureListener(this);
			notifyObservers(new DrawModelEvent(this, f, Type.FIGURE_REMOVED));
		}
	}

	@Override
	public void addModelChangeListener(DrawModelListener l) {
		listener.add(l);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener l) {
		listener.remove(l);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
		int oldIndex = figures.indexOf(f);
		if(oldIndex < 0){ throw new IllegalArgumentException(); }
		if(index < 0 || index >= figures.size()){ throw new IndexOutOfBoundsException(); }
		if(oldIndex != index){
			figures.remove(f);
			figures.add(index, f);
			notifyObservers(new DrawModelEvent(this, f, Type.DRAWING_CHANGED));
		}
	}

	@Override
	public void removeAllFigures() {
		for(Figure f : figures){ f.removeFigureListener(this); }
		figures.clear();
		notifyObservers(new DrawModelEvent(this, null, Type.DRAWING_CLEARED));
	}
}
