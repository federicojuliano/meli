package api.view;

public class RespuestaPeriodosView {

	private int periodosDeSequia;
	
	private int periodosDeLluvia;
	
	private int periodosDeCondOptimas;
	
	private int diaDePicoMaximoLluvia;
	
	public int getCantSequia() {
		return periodosDeSequia;
	}

	public void setCantSequia(int cantSequia) {
		this.periodosDeSequia = cantSequia;
	}

	public int getCantLluvia() {
		return periodosDeLluvia;
	}

	public void setCantLluvia(int cantLluvia) {
		this.periodosDeLluvia = cantLluvia;
	}

	public int getCantCondOptimas() {
		return periodosDeCondOptimas;
	}

	public void setCantCondOptimas(int cantCondOptimas) {
		this.periodosDeCondOptimas = cantCondOptimas;
	}

	public int getDiaPicoMaximoLluvia() {
		return diaDePicoMaximoLluvia;
	}

	public void setDiaPicoMaximoLluvia(int diaPicoMaximoLluvia) {
		this.diaDePicoMaximoLluvia = diaPicoMaximoLluvia;
	}
	
	public void incrementarLluvia() {
		this.periodosDeLluvia ++;
	}
	
	public void incrementarSequia() {
		this.periodosDeSequia ++;
	}
	
	public void incrementarCondOptimas() {
		this.periodosDeCondOptimas ++;
	}
}
