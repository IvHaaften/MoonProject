package MaanProject;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PERCEELTYPE")
@NoArgsConstructor
public class Perceel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;

    private int oppervlakte;

    private Polygon begrenzing;

    private boolean beperking;

	@ManyToOne
    private Inwoner eigenaar;

	@OneToMany(mappedBy = "perceel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Transactie> transacties;

	public Perceel(Polygon begrenzing, Inwoner eigenaar) {
		this.begrenzing = begrenzing;
		this.eigenaar = eigenaar;
	}

	public Integer getId() {
		return id;
	}
	public int getOppervlakte() {
		return oppervlakte;
	}
	public Polygon getBegrenzing() {
		return begrenzing;
	}

	@Override
	public String toString() {
		return "Perceel{" +
				"id=" + id +
				", eigenaar=" + eigenaar +
				'}';
	}

	public void setBegrenzing(Polygon begrenzing) {
		this.begrenzing = begrenzing;
		this.oppervlakte = 5; //moet berekend worden op basis van de begrenzing
	}
	public boolean isBeperking() {
		return beperking;
	}
	public void setBeperking(boolean beperking) {
		this.beperking = beperking;
	}
	public Inwoner getEigenaar() {
		return eigenaar;
	}
	public void setEigenaar(Inwoner eigenaar) {
		this.eigenaar = eigenaar;
	}

}
