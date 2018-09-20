package api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.view.RespuestaClimaDiaPuntualView;
import api.view.RespuestaPeriodosView;

@ApplicationPath("/path")
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClimaRest extends Application{

	private static final int DIEZ_ANIOS = 10;

	@POST
	@Path("/climaDia")
//	PATH PARA ACCEDER: http://localhost:8080/api-juliano-0.0.1-SNAPSHOT/path/api/climaDia/
	public Response obtenerClimaPorDia(DiaConsultado request) {
		ClimaManager smn = new ClimaManager();
		RespuestaClimaDiaPuntualView respuestaView = smn.predecirPorDia(request.getDia());
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/climaDia")
	// http://localhost:8080/api-juliano-0.0.1-SNAPSHOT/path/api/obtenerDia?{request="dias":1}
	public Response obtenerClimaPorDiaGet(DiaConsultado request) {
		ClimaManager smn = new ClimaManager();
		RespuestaClimaDiaPuntualView respuestaView = smn.predecirPorDia(request.getDia());
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/predecirDiezAnios")
	//http://localhost:8080/api-juliano-0.0.1-SNAPSHOT/path/api/predecirDiezAnios/
	//request: {"dia":566}
	public Response predecirDiezAnios() {
		ClimaManager smn = new ClimaManager();
		int aniosConsultados = DIEZ_ANIOS;
		RespuestaPeriodosView respuestaView = smn.predecirProximosAnios(aniosConsultados);
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/predecirDiezAnios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response predecirDiezAniosGet() {
		ClimaManager smn = new ClimaManager();
		int aniosConsultados = DIEZ_ANIOS;
		RespuestaPeriodosView respuestaView = smn.predecirProximosAnios(aniosConsultados);
	    return Response.ok(respuestaView, MediaType.APPLICATION_JSON).build();
	}
}
