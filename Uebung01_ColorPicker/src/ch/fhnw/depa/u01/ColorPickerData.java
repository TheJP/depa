package ch.fhnw.depa.u01;

import java.util.Observable;

/**
 * Data which is used by the ColorPicker
 * @author JP
 *
 */
public class ColorPickerData extends Observable {
	private short red;
	private short green;
	private short blue;

	private short norm(int color){ return (short)Math.max(Math.min(color, 255), 0); }

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

	public void set(int red, int green, int blue){
		if(this.red != red || this.green != green || this.blue != blue) {
			this.red = norm(red);
			this.green = norm(green);
			this.blue = norm(blue);
			this.setChanged();
			this.notifyObservers();
		}
	}

	public short getRed() {
		return red;
	}

	public void setRed(int red) {
		if(this.red != red) {
			this.red = norm(red);
			this.setChanged();
			this.notifyObservers();
		}
	}

	public short getGreen() {
		return green;
	}

	public void setGreen(int green) {
		if(this.green != green) {
			this.green = norm(green);
			this.setChanged();
			this.notifyObservers();
		}
	}

	public short getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		if(this.blue != blue) {
			this.blue = norm(blue);
			this.setChanged();
			this.notifyObservers();
		}
	}
}
