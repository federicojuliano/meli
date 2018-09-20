package api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiaConsultado {

	private int dia;

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
}
