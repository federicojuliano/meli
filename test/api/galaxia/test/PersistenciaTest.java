package api.galaxia.test;

import java.util.Random;

import org.junit.Test;

import api.Persistencia;
import api.comun.TipoClimaEnum;

public class PersistenciaTest {

	@Test
	public void almacenarRegistroTest() throws Exception {
		String nombreArchivo = "archivo-salida-test";
		Persistencia persistencia = new Persistencia(nombreArchivo);
		
		TipoClimaEnum[] climas = TipoClimaEnum.values();
		Random rand = new Random();
		for(int i = 0 ; i < 50 ; i++) {
			persistencia.almacenarRegistro(climas[rand.nextInt(3)], i);
		}
		
	}
}
