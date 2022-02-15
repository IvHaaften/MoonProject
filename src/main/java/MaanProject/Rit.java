package MaanProject;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Rit
{
	//record ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Map<Zitplaats, Inwoner> passagiersLijst;

	@OneToMany(mappedBy = "rit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ArrayDeque<Vracht> vrachtLijst;

	private ZonedDateTime vertrektijd;
	private Station beginStation;
	private Station eindStation;

	private Rit(Map<Zitplaats, Inwoner> passagiersLijst, ArrayDeque<Vracht> vrachtLijst, ZonedDateTime vertrektijd, Station beginStation, Station eindStation)
	{
		this.passagiersLijst = passagiersLijst;

		this.vrachtLijst = vrachtLijst;
		this.vertrektijd = vertrektijd;
		this.beginStation = beginStation;
		this.eindStation = eindStation;
	}


}
