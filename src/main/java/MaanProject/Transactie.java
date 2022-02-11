package MaanProject;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transactie {
	//record ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;

    private final LocalDate datum;
	@ManyToOne
    private final Inwoner verkoper;
	@ManyToOne
    private final Inwoner aankoper;

	@ManyToOne
	@JoinColumn(name = "perceel_id")
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
		this.perceel.setEigenaar(aankoper);
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
