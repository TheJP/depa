package ch.fhnw.depa.u01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listener for all actions of the ColorPicker
 * @author JP
 *
 */
public class ColorPickerActionListener implements ActionListener {

	private ColorPickerData data;

	public ColorPickerActionListener(ColorPickerData data) {
		this.data = data;
	}

	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "darker":
				data.set((int)(data.getRed() * 0.9), (int)(data.getGreen() * 0.9), (int)(data.getBlue() * 0.9));
				break;
			case "brighter":
				data.set((int)(data.getRed() * 1.1), (int)(data.getGreen() * 1.1), (int)(data.getBlue() * 1.1));
				break;
			case "red":
				data.set(255, 0, 0);
				break;
			case "green":
				data.set(0, 255, 0);
				break;
			case "blue":
				data.set(0, 0, 255);
				break;
			case "yellow":
				data.set(255, 255, 0);
				break;
			case "orange":
				data.set(255, 175, 0);
				break;
			case "black":
				data.set(0, 0, 0);
				break;
			case "grey":
				data.set(100, 100, 100);
				break;
		}
	}

	public ScrollListener createScrollListener(int color){
		return new ScrollListener(color);
	}

	public class ScrollListener implements ChangeListener {

		public static final int RED = 0;
		public static final int GREEN = 1;
		public static final int BLUE = 2;
		private int color = RED;

		public ScrollListener(int color) {
			this.color = color;
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			int value = ((DefaultBoundedRangeModel)e.getSource()).getValue();
			switch(color) {
				case RED: data.setRed(value); break;
				case GREEN: data.setGreen(value); break;
				case BLUE: data.setBlue(value); break;
			}
		}
	}

}
