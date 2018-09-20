package api.galaxia.test;

import org.junit.Test;

import api.comun.VectorXY;
import api.galaxia.Betasoide;

public class BetasoideTest {

	@Test
	public void obtenerPosicionBetasoideTest() {
		Betasoide betasoide = new Betasoide();
		int posicion;
		for(int i = 0 ; i < 3650 ; i++) {
			posicion = betasoide.obtenerPosicionAngular(i);
			System.out.println("Dia: " + i + " - Posicion: " + posicion);
		}
	}
	
	
	@Test
	public void obtenerVectorPosicionTest() {
		Betasoide betasoide = new Betasoide();
		VectorXY posicion = new VectorXY();
		for(int i = 0 ; i < 360 ; i+=90) {
			posicion = betasoide.obtenerVectorPosicion(i);
			System.out.println("Distancia sol: " + betasoide.getDistanciaAlSol() + " - Pos. angular: " + i + " - Vector: (" + posicion.getPosX() + "," + posicion.getPosY() + ")");
		}
	}
}
