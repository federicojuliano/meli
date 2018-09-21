package api;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import api.comun.TipoClimaEnum;

public class Persistencia {
	
	private String nombreArchivo;
	
	public Persistencia(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo + ".txt";
		generarArchivoNuevo();
	}


	public void almacenarRegistro(TipoClimaEnum estacion, int i) throws Exception {
		PrintWriter printWriter = null;
        try {
            
        	printWriter = new PrintWriter(new FileWriter(this.nombreArchivo, true));
			printWriter.println("Dia: " + i + " - clima: " + estacion);
            
        } catch (FileNotFoundException e) {
        	System.out.println("Error al grabar archivo. " + this.nombreArchivo);
        	throw new Exception();
        } catch (IOException e) {
        	System.out.println("Error al grabar archivo. " + this.nombreArchivo);
        	throw new Exception();
		}finally {
            if(printWriter != null) {
                printWriter.close();
            }else {
            	System.out.println("Hubo un error en la persistencia de los datos. " + this.nombreArchivo);
            	throw new Exception();
            }
        }
	}

	@SuppressWarnings("resource")
	private void generarArchivoNuevo() {
		try {
			new PrintWriter(this.nombreArchivo);
		} catch (FileNotFoundException e) {
			System.out.println("Hubo un error creando el archivo por primera vez. " + this.nombreArchivo);
		}
	}
}
