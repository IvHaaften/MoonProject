package MaanProject;

import java.time.LocalDate;

public class Transactie {
    private final LocalDate datum;
    private final Inwoner verkoper;
    private final Inwoner aankoper;
	private final Perceel perceel;

	public Transactie(LocalDate datum, Inwoner verkoper, Inwoner aankoper, Perceel perceel) {
		if(this.getPerceel().isBeperking()){
			throw new RuntimeException("Dit perceel kan niet verhandeld worden vanwege een beperking");
		}
		if(!perceel.getEigenaar().equals(verkoper)){
			throw new RuntimeException("Dit perceel is geen eigendom van de ingestelde verkoper");
		}
		if(verkoper.equals(aankoper)){
			throw new RuntimeException("Een perceel kan niet verkocht worden aan jezelf");
		}

		this.datum = datum;
		this.verkoper = verkoper;
		this.aankoper = aankoper;
		this.perceel = perceel;
		// hier zou de transactie opgeslagen worden in de database

		this.perceel.setEigenaar(aankoper);
		// perceel opslaan in de database
	}
    
	public LocalDate getDatum() {
		return datum;
	}
	public Inwoner getVerkoper() {
		return verkoper;
	}
	public Inwoner getAankoper() {
		return aankoper;
	}
	public Perceel getPerceel() {
		return perceel;
	}
}
