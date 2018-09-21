package api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.manager.ClimaManager;
import api.view.DiaConsultadoViewRequest;
import api.view.RespuestaClimaDiaPuntualView;
import api.view.RespuestaModeloGeneradoView;
import api.view.RespuestaPeriodosView;

@ApplicationPath("/path")
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//http://localhost:8080/api-juliano-0.0.1-SNAPSHOT/path/api/
public class ClimaRest extends Application{

	private static final int DIEZ_ANIOS = 10;

	@POST
	@Path("/climaDia")
	//request ejemplo: {"dia":566}
	public Response obtenerClimaPorDia(DiaConsultadoViewRequest request) {
		ClimaManager smn = new ClimaManager();
		RespuestaClimaDiaPuntualView respuestaView = smn.predecirPorDia(request.getDia());
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/predecirDiezAnios")
	public Response predecirDiezAnios() {
		ClimaManager smn = new ClimaManager();
		int aniosConsultados = DIEZ_ANIOS;
		RespuestaPeriodosView respuestaView = smn.predecirProximosAnios(aniosConsultados);
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/generarModeloDatos")
	public Response generarModeloDatos() {
		ClimaManager smn = new ClimaManager();
		int aniosAGenerar = DIEZ_ANIOS;
		RespuestaModeloGeneradoView respuestaView = smn.generarModeloDatos(aniosAGenerar);
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
}
