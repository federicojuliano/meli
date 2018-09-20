package api.galaxia;

import api.comun.VectorXY;

public abstract class AbstractCivilizacion {

	
	/** Siento verdadero cuando la civilizacion gira en sentido horario,
	 * y falso cuando es sentido anti-horario.*/
	private boolean sentidoGiroHorario;
	
	/** Expresada en grados por dia.*/
	private int velocidadAngular;
	
	/** Distancia en km de la orbita de la galaxia al sol.*/
	private int distanciaAlSol;
	
	public AbstractCivilizacion(boolean sentidoGiroHorario, int velocidadAngular, int distanciaAlSol) {
		
		this.sentidoGiroHorario = sentidoGiroHorario;
		this.velocidadAngular = velocidadAngular;
		this.distanciaAlSol = distanciaAlSol;
	}
	
	public boolean isSentidoGiroHorario() {
		return sentidoGiroHorario;
	}

	public int getVelocidadAngular() {
		return velocidadAngular;
	}

	public int getDistanciaAlSol() {
		return distanciaAlSol;
	}
	
	public int obtenerPosicionAngular(int dias) {

		int posicion = dias * this.velocidadAngular;
		if(posicion > 360) {
			posicion = posicion % 360;
		}
		if(!this.sentidoGiroHorario && posicion != 0) {
			posicion = 360 - posicion;
		}
		return posicion;
	}
	
	public VectorXY obtenerVectorPosicion(int posicionAngular) {
		VectorXY vectorPos = new VectorXY();
		
		if(posicionAngular == 180 || posicionAngular == 360) {
			vectorPos.setPosX(0);
		}else {
			vectorPos.setPosX(this.distanciaAlSol * Math.sin(Math.toRadians(posicionAngular)));
		}
		
		if(posicionAngular == 90 || posicionAngular == 270) {
			vectorPos.setPosY(0);
		}else {
			vectorPos.setPosY(this.distanciaAlSol * Math.cos(Math.toRadians(posicionAngular)));
		}
		
		return vectorPos;
	}

}
