package api.comun;

public enum TipoClimaEnum {

	LLUVIA("lluvia"),
	
	SEQUIA("sequia"),
	
	CONDICIONES_OPTIMAS("condiciones optimas"),
	
	TRIANGULO_SIN_SOL_ADENTRO("triangulo formado con el sol fuera");
	
	private String descripcion;
	
	private TipoClimaEnum(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public TipoClimaEnum obtenerPorDescripcion(String descripcion) {
		for (TipoClimaEnum estacionIt : TipoClimaEnum.values()) {
			if(estacionIt.getDescripcion().equals(descripcion)) {
				return estacionIt;
			}
		}
		return null;
	}
}
