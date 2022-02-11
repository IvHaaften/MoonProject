package MaanProject;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PERCEELTYPE")
public class Perceel {
	@Id
    private final UUID id;
    private int oppervlakte;

    private Polygon begrenzing;

    private boolean beperking;

	@ManyToOne
    private Inwoner eigenaar;

	@OneToMany(mappedBy = "perceel", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Transactie> transacties;

	public Perceel(Polygon begrenzing, Inwoner eigenaar) {
		this.id = UUID.randomUUID();
		this.begrenzing = begrenzing;
		this.eigenaar = eigenaar;
	}

	public UUID getId() {
		return id;
	}
	public int getOppervlakte() {
		return oppervlakte;
	}
	public Polygon getBegrenzing() {
		return begrenzing;
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
