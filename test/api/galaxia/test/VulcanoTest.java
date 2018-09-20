package api.galaxia.test;

import org.junit.Test;

import api.comun.VectorXY;
import api.galaxia.Vulcano;

public class VulcanoTest {

	@Test
	public void obtenerPosicionVulcanoTest() {
		Vulcano vulcano = new Vulcano();
		int posicion;
		for(int i = 0 ; i < 3650 ; i++) {
			posicion = vulcano.obtenerPosicionAngular(i);
			System.out.println("Dia: " + i + " - Posicion: " + posicion);
		}
	}
	
	@Test
	public void obtenerVectorPosicionVulcanoTest() {
		Vulcano betasoide = new Vulcano();
		VectorXY posicion = new VectorXY();
		for(int i = 0 ; i <= 360 ; i+=10) {
			posicion = betasoide.obtenerVectorPosicion(i);
			System.out.println("Distancia sol: " + betasoide.getDistanciaAlSol() + " - Pos. angular: " + i + " - Vector: (" + posicion.getPosX() + ", " + posicion.getPosY() + ")");
		}
	}
}
