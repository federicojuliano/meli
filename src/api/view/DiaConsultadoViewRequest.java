package api.view;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaConsultadoViewRequest {

	private int dia;

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
}
