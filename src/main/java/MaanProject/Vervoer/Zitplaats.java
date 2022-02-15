package MaanProject.Vervoer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Zitplaats
{
	//record ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "reservering_id")
	private Reservering reservering;

	private Integer plaatsNummer;

	public Zitplaats(Integer plaatsNummer, Reservering reservering)
	{
		this.plaatsNummer = plaatsNummer;
		this.reservering = reservering;
	}
}
