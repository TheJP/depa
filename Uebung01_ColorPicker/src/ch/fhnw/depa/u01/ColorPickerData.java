package ch.fhnw.depa.u01;

import java.util.Observable;

/**
 * 
 * @author JP
 *
 */
public class ColorPickerData extends Observable {
	private short red;
	private short green;
	private short blue;

	public ColorPickerData() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}

	public ColorPickerData(short red, short green, short blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public short getRed() {
		return red;
	}

	public void setRed(short red) {
		this.red = red;
		this.notifyObservers();
	}

	public short getGreen() {
		return green;
	}

	public void setGreen(short green) {
		this.green = green;
		this.notifyObservers();
	}

	public short getBlue() {
		return blue;
	}

	public void setBlue(short blue) {
		this.blue = blue;
		this.notifyObservers();
	}
}
