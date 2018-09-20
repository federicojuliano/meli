package api;

import api.comun.TipoClimaEnum;
import api.comun.VectorXY;
import api.galaxia.Betasoide;
import api.galaxia.Ferengi;
import api.galaxia.Vulcano;
import api.view.RespuestaClimaDiaPuntualView;
import api.view.RespuestaPeriodosView;

/** Clase para predecir el clima
 * @author federico juliano
 *
 */
public class ClimaManager {

	public RespuestaPeriodosView predecirProximosAnios(int anios) {
		
		RespuestaPeriodosView respuesta = new RespuestaPeriodosView();
		
		Meteorologo meteorologo = new Meteorologo();
		Betasoide be = new Betasoide();
		Ferengi fe = new Ferengi();
		Vulcano vu = new Vulcano();
		
		//SE HACE UN ESTIMATIVO DE ANIOS BISIESTOS
		int cantidadBisiestos = 0; 
		if(anios > 4) {
			cantidadBisiestos = anios % 4;
		}
		int diasEvaluados = anios * 365 + cantidadBisiestos;
		
		TipoClimaEnum estacion;
		int trianguloMayor = 0;
		int perimetroTriangulo = 0;
		for(int i = 0 ; i < diasEvaluados ; i++) {
			
			estacion = meteorologo.predecirClima(be, fe, vu, i);
			switch (estacion) {
			case LLUVIA:
				respuesta.incrementarLluvia();
				perimetroTriangulo = obtenerPerimetroTriangulo(be, fe, vu, i);
				if(perimetroTriangulo > trianguloMayor) {
					respuesta.setDiaPicoMaximoLluvia(i);
				}
				break;
			case SEQUIA:
				respuesta.incrementarSequia();
				break;
			case CONDICIONES_OPTIMAS:
				respuesta.incrementarCondOptimas();
			case TRIANGULO_SIN_SOL_ADENTRO:
			default:
				break;
			}
		}
		return respuesta;
	}
	
	private int obtenerPerimetroTriangulo(Betasoide be, Ferengi fe, Vulcano vu, int dias) {

		int perimetro = 0;
		
		VectorXY vectorBe = be.obtenerVectorPosicion(be.obtenerPosicionAngular(dias));
		VectorXY vectorFe = fe.obtenerVectorPosicion(fe.obtenerPosicionAngular(dias));
		VectorXY vectorVu = vu.obtenerVectorPosicion(vu.obtenerPosicionAngular(dias));
		
		perimetro += distanciaEntreDosPuntos(vectorBe, vectorFe);
		perimetro += distanciaEntreDosPuntos(vectorFe, vectorVu);
		perimetro += distanciaEntreDosPuntos(vectorVu, vectorBe);
		
		return perimetro;
	}

	private double distanciaEntreDosPuntos(VectorXY vector1, VectorXY vector2) {
		return Math.sqrt(Math.pow((vector1.getPosX() - vector2.getPosX()), 2) + Math.pow((vector1.getPosY() - vector2.getPosY()), 2));
	}

	/** Devuelve el pronostico del dia consultado
	 * @param dia
	 * @return
	 */
	public RespuestaClimaDiaPuntualView predecirPorDia(int dia) {
		
		Meteorologo meteorologo = new Meteorologo();
		Betasoide be = new Betasoide();
		Ferengi fe = new Ferengi();
		Vulcano vu = new Vulcano();
		
		TipoClimaEnum clima = meteorologo.predecirClima(be, fe, vu, dia);
		
		RespuestaClimaDiaPuntualView respuesta = new RespuestaClimaDiaPuntualView();
		respuesta.setClima(clima.getDescripcion());
		respuesta.setDia(dia);
		
		return respuesta;
	}
}
