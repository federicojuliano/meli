package api.galaxia.test;

import org.junit.Test;

import api.ClimaManager;
import api.view.RespuestaPeriodosView;

public class ClimaManagerTest {

	@Test
	public void predecirPorDiaTest() {
		ClimaManager servicioClima = new ClimaManager();
		int dia = 3629;
		servicioClima.predecirPorDia(dia);
	}
	
	@Test
	public void predecirProximosAnios() {
		ClimaManager servicioClima = new ClimaManager();
		int anios = 10;
		RespuestaPeriodosView pronostico = servicioClima.predecirProximosAnios(anios);
		System.out.println("Lluvias: " + pronostico.getCantLluvia());
		System.out.println("Condiciones optimas: " + pronostico.getCantCondOptimas());
		System.out.println("Sequias: " + pronostico.getCantSequia());
		System.out.println("Dia maxima lluvia: " + pronostico.getDiaPicoMaximoLluvia());
	}
}
