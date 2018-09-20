package api.comun;

import java.text.DecimalFormat;

public class VectorXY {

	private double posX;
	
	private double posY;

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		DecimalFormat df = new DecimalFormat("#########.#");
		this.posX = Double.parseDouble(df.format(posX).replaceAll(",", "."));
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		DecimalFormat df = new DecimalFormat("#########.#");
		this.posY = Double.parseDouble(df.format(posY).replaceAll(",", "."));
	}
}
