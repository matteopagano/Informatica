package alberobin;

import static java.util.Arrays.sort;

/**
 *
 * @author matteo.pagano
 */
public class AlberoBin<T> {

	T info;
	AlberoBin<T> destra;
	AlberoBin<T> sinistra;

	AlberoBin(T info, AlberoBin<T> destra, AlberoBin<T> sinistra) {
		this.info = info;
		this.destra = destra;
		this.sinistra = sinistra;
	}

	AlberoBin() {
		this.info = null;
		this.destra = null;
		this.sinistra = null;
	}

	public T getInfo() {
		return info;
	}

	public AlberoBin<T> getDestra() {
		return destra;
	}

	public AlberoBin<T> getSinistra() {
		return sinistra;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setDestra(AlberoBin<T> destra) {
		this.destra = destra;
	}

	public void setSinistra(AlberoBin<T> sinistra) {
		this.sinistra = sinistra;
	}

	public boolean isEmpty() {
		return this.getInfo() == null;
	}

	public void visitaAnticipata() {
		visitaAnticipata(this);
	}

	private void visitaAnticipata(AlberoBin a) {
		if (!a.isEmpty()) {
			System.out.println(a.getInfo());
			if (a.getSinistra() != null) {
				visitaAnticipata(a.getSinistra());
			}
			if (a.getDestra() != null) {
				visitaAnticipata(a.getDestra());
			}
		}
	}

	public void visitaDifferita() {
		visitaDifferita(this);
	}

	private void visitaDifferita(AlberoBin a) {
		if (!a.isEmpty()) {
			if (a.getSinistra() != null) {
				visitaAnticipata(a.getSinistra());
			}
			if (a.getDestra() != null) {
				visitaAnticipata(a.getDestra());
			}
			System.out.println(a.getInfo());
		}
	}

	public void visitaSimmetrica() {
		visitaDifferita(this);
	}

	private void visitaSimmetrica(AlberoBin a) {
		if (!a.isEmpty()) {
			if (a.getSinistra() != null) {
				visitaAnticipata(a.getSinistra());
			}
			System.out.println(a.getInfo());
			if (a.getDestra() != null) {
				visitaAnticipata(a.getDestra());
			}
		}
	}

}
