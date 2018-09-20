package api;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import api.comun.TipoClimaEnum;
import api.comun.VectorXY;
import api.galaxia.Betasoide;
import api.galaxia.Ferengi;
import api.galaxia.Vulcano;

/** Clase encargada de realizar la accion de predecir el clima concretamente
 * @author federico juliano
 *
 */
public class Meteorologo {

	public TipoClimaEnum predecirClima(Betasoide be, Ferengi fe, Vulcano vu, int dias) {
		
		int posBe = be.obtenerPosicionAngular(dias);
		int posFe = fe.obtenerPosicionAngular(dias);
		int posVu = vu.obtenerPosicionAngular(dias);
		
		if(((posBe == posFe) || (Math.abs(posBe - posFe)) == 180) 
				&& ((posBe == posVu) || (Math.abs(posBe - posVu) == 180 ))) {
			//PLANETAS ALINEADOS CON EL SOL
			return TipoClimaEnum.SEQUIA;
		}
		
		ArrayList<Integer> posiciones = new ArrayList<>();
		posiciones.add(posBe);
		posiciones.add(posFe);
		posiciones.add(posVu);
		Collections.sort(posiciones);
		
		if((posiciones.get(2)-posiciones.get(0) > 180 
				&& (posiciones.get(2)-posiciones.get(1) < 180 )
				&& (posiciones.get(1)-posiciones.get(0) < 180 ))){
			//TRIANGULO FORMADO CON SOL ENCERRADO
			return TipoClimaEnum.LLUVIA;
		}
		
		VectorXY vectorBe = be.obtenerVectorPosicion(posBe);
		VectorXY vectorFe = fe.obtenerVectorPosicion(posFe);
		VectorXY vectorVu = vu.obtenerVectorPosicion(posVu);
		
		if(estanAlineados(vectorBe, vectorFe, vectorVu)) {
			return TipoClimaEnum.CONDICIONES_OPTIMAS;
		}
		
		return TipoClimaEnum.TRIANGULO_SIN_SOL_ADENTRO;
	}

	/** Se devuelve true o false segun si cumple la siguiente formula:
	 * ((x2-x1)/(x3-x2)=((y2-y1)/(y3-y2))
	 * @param vector1 = (x1, y1)
	 * @param vector2 = (x2, y2)
	 * @param vector3 = (x3, y3)
	 * @return
	 */
	private boolean estanAlineados(VectorXY vector1, VectorXY vector2, VectorXY vector3) {

		double numX, numY, denomX, denomY;
		numX = (vector2.getPosX() - vector1.getPosX());
		denomX = (vector3.getPosX() - vector2.getPosX());
		numY = (vector2.getPosY() - vector1.getPosY());
		denomY = (vector3.getPosY() - vector2.getPosY());
		
		//VALIDACIONES DE CASOS ESPECIALES DONDE LAS RESTAS DAN CERO
		//Y SEGUN EL CASO SE DETERMINA SI ESTAN ALINEADOS O NO
		if(numX == 0 && denomX == 0) {
			return true;
		}else if(numX == 0 || denomX == 0) {
			return false;
		}
		if(numY == 0 && denomY == 0) {
			return true;
		}else if(numY == 0 || denomY == 0) {
			return false;
		}
		
		//FORMULA MATEMATICA PARA 3 PUNTOS COLINEALES
		DecimalFormat df = new DecimalFormat("#########.##");
		double compX = Double.parseDouble(df.format(numX / denomX).replaceAll(",", "."));
		double compY = Double.parseDouble(df.format(numY / denomY).replaceAll(",", "."));

		if(compX == compY) {
			return true;
		}
		return false;
	}
}
