package src.main.java;

import java.time.LocalDate;

public class Transactie {
    private LocalDate datum;
    private Inwoner verkoper;
    private Inwoner aankoper;
    private Perceel perceel;
    
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public Inwoner getVerkoper() {
		return verkoper;
	}
	public void setVerkoper(Inwoner verkoper) {
		this.verkoper = verkoper;
	}
	public Inwoner getAankoper() {
		return aankoper;
	}
	public void setAankoper(Inwoner aankoper) {
		this.aankoper = aankoper;
	}
	public Perceel getPerceel() {
		return perceel;
	}
	public void setPerceel(Perceel perceel) {
		this.perceel = perceel;
	}
}
